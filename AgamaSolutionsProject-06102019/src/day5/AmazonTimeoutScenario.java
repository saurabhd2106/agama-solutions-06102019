package day5;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonTimeoutScenario {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver;

		System.setProperty("webdriver.chrome.driver",
				"C:/Users/Saurabh Dhingra/workspace/libs/chromedriver_74/chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.amazon.in");

		Actions action = new Actions(driver);

		WebElement shopByCatLink = driver.findElement(By.id("nav-link-shopall"));

		action.moveToElement(shopByCatLink).build().perform();

		waitTillElementVisible(driver, 10, By.xpath("//span[text()='Fire TV Stick']"));

		WebElement fireTvLink = driver.findElement(By.xpath("//span[text()='Fire TV Stick']"));

		action.moveToElement(fireTvLink).build().perform();

		waitTillElementVisible(driver, 10, By.xpath("//span[text()='Fire TV Stick with all-new Alexa Voice Remote']"));
		WebElement fireTvInternalLink = driver
				.findElement(By.xpath("//span[text()='Fire TV Stick with all-new Alexa Voice Remote']"));

		action.moveToElement(fireTvInternalLink).click().build().perform();

	}

	private static void waitTillElementVisible(WebDriver driver, int timeout, By by) {

		WebDriverWait wait = new WebDriverWait(driver, timeout);

		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public static void fluentWait(WebDriver driver, int timeout, int pollingTime, By by) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeout))
				.pollingEvery(Duration.ofSeconds(pollingTime))
				.ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

}
