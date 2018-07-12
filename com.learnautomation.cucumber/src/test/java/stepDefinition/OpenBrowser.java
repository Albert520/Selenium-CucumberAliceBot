package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowser {
	WebDriver driver;

	public void Open_chrome_and_start_application() throws Throwable {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://alicedev.sogeti.be/");
	}
}
