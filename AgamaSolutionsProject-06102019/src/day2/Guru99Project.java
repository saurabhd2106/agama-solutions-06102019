package day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Guru99Project {

	ChromeDriver driver;

	public void invokeBrowser() {

		System.setProperty("webdriver.chrome.driver",
				"C:/Users/Saurabh Dhingra/workspace/libs/chromedriver_74/chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
		driver.get("http://demo.guru99.com/v4/");
	}

	public void login(String userId, String userPassword) {
		WebElement usernameElement = driver.findElement(By.name("uid"));

		usernameElement.sendKeys(userId);

		driver.findElement(By.name("password")).sendKeys(userPassword);

		driver.findElement(By.name("btnLogin")).click();

	}

	public void addCustomer() {
		driver.findElement(By.linkText("New Customer")).click();

		String emailId = "sau" + System.currentTimeMillis() + "@xyz.com";
	}

	public String getCustomerId() {

		return driver.findElement(By.xpath("//table[@id='customer']/tbody/tr[4]/td[2]")).getText();
	}

	public void addAccount(String customerId) {

		WebElement dropdown = driver.findElement(By.name("cusid"));
		Select selAccount = new Select(dropdown);

		boolean statusFlag = selAccount.isMultiple();

		System.out.println(statusFlag);
		selAccount.selectByVisibleText("Current");

	}

	public int getLinkCount() {

		List<WebElement> allLinks;

		allLinks = driver.findElements(By.tagName("a"));

		return allLinks.size();

	}

	public void getAllLinksDetail() {
		List<WebElement> allLinks;

		allLinks = driver.findElements(By.tagName("a"));

		for (WebElement link : allLinks) {

			System.out.println("Text : " + link.getText() + " and the url is : " + link.getAttribute("href"));
		}
	}

}
