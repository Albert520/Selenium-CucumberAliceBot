$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/MyApplication.feature");
formatter.feature({
  "name": "Test Facebook smoke scenario",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Test login with valid credentials",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "Open chrome and start application",
  "keyword": "Given "
});
formatter.step({
  "name": "I enter valid \"\u003cusername\u003e\" and valid \"\u003cpassword\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "user should be able to login successfully",
  "keyword": "Then "
});
formatter.step({
  "name": "communicate with Alice \"\u003cnumber\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "name": "application should be closed",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "username",
        "password",
        "number"
      ]
    },
    {
      "cells": [
        "akural",
        "1314871",
        "66"
      ]
    },
    {
      "cells": [
        "akural",
        "1314871",
        "67"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Test login with valid credentials",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "Open chrome and start application",
  "keyword": "Given "
});
formatter.match({
  "location": "SmokeTest.Open_chrome_and_start_application()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter valid \"akural\" and valid \"1314871\"",
  "keyword": "When "
});
formatter.match({
  "location": "SmokeTest.I_enter_valid_username_and_valid_password(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user should be able to login successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "SmokeTest.user_should_be_able_to_login_successfully()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "communicate with Alice \"66\"",
  "keyword": "Then "
});
formatter.match({
  "location": "SmokeTest.communicate_with_Alice(String)"
});
