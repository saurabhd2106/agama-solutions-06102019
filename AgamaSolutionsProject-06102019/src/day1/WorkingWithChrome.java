package day1;

import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWithChrome {

	ChromeDriver driver;

	public void invokeBrowser() {

		System.setProperty("webdriver.chrome.driver",
				"C:/Users/Saurabh Dhingra/workspace/libs/chromedriver_74/chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.get("http://qatechhub.com");
	}

	public void getTitleOfThePage() {
		System.out.println("Title of the page :: " + driver.getTitle());
	}

	public void closeBrowser() {
		// driver.close(); //It closes the current active window

		driver.quit(); // It closes all the window opened by selenium
	}

	public void navigateCommands() {

		driver.navigate().to("http://facebook.com");

		driver.navigate().back();

		driver.navigate().forward();

		driver.navigate().refresh();

	}

}
