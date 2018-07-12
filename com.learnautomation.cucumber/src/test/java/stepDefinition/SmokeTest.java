package stepDefinition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import net.bytebuddy.description.annotation.AnnotationList.Empty;

public class SmokeTest {

	WebDriver driver;
	private String buttonToSendMessageToAlice = "//*[@id=\"textForm\"]/div/button";
	private String buttonModifyTicket = "//*[@id=\"conversation\"]/div/p/button[3]";
	private int timeWait = 1500;

	@Given("^Open chrome and start application$")
	public void Open_chrome_and_start_application() throws Throwable {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://alicedev.sogeti.be/");
	}

	@When("^I enter valid \"([^\"]*)\" and valid \"([^\"]*)\"$")
	public void I_enter_valid_username_and_valid_password(String name, String password) throws Throwable {
		driver.findElement(By.id("username")).sendKeys(name);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("submit")).click();
	}

	@Then("user should be able to login successfully")
	public void user_should_be_able_to_login_successfully() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(timeWait);
		try {
			driver.findElement(By.id("userInput")).sendKeys("Hello Alice!");
			if (!(driver.findElement(By.id("userInput")).getAttribute("value").equals("Hello Alice!"))) {
				Assert.fail();
			}
			driver.findElement(By.xpath(buttonToSendMessageToAlice)).click();
		} catch (AssertionError e) {
			throw (e);
		}
	}

	//testing if the captcha will appear after 60 times like the developpers want
	@Then("communicate with Alice {string}")
	public void communicate_with_Alice(String string) throws Throwable {

		int n = Integer.parseInt(string);
		for (int i = 0; i < n - 1; i++) {
			try {
			//	if (driver.findElement(By.id("captcha")).getAttribute("style").equals("display: block;")) { System.out.println("captcha appear!");}
				Thread.sleep(timeWait);
				driver.findElement(By.id("userInput")).sendKeys("Hello Alice!" + i);
				driver.findElement(By.xpath(buttonToSendMessageToAlice)).click();
			} catch (AssertionError e) {
				System.out.println("Communication with Alice failed");
				throw new Exception("FUCK");
			}
		}

		try {
			Thread.sleep(timeWait);
			driver.findElement(By.id("userInput")).sendKeys("help");
			Thread.sleep(timeWait);
			driver.findElement(By.xpath(buttonToSendMessageToAlice)).click();
			Thread.sleep(timeWait);
			driver.findElement(By.xpath(buttonModifyTicket)).click();
			Thread.sleep(timeWait);
			driver.findElement(By.id("userInput")).sendKeys("toueic");
			driver.findElement(By.xpath(buttonToSendMessageToAlice)).click();
			Thread.sleep(timeWait);
		} catch (AssertionError e) {
			e.getCause();
		}

	}

	@Then("application should be closed")
	public void application_should_be_closed() throws Throwable {
		driver.quit();
	}
}
