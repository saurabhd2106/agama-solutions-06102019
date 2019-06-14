package day5;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AmazonProject {
	
	ChromeDriver driver;

	public void invokeBrowser() {

		System.setProperty("webdriver.chrome.driver",
				"C:/Users/Saurabh Dhingra/workspace/libs/chromedriver-2.46/chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.amazon.in");

	}

	public void closeBrowser() {
		driver.quit();
	}

	public String searchProduct(String product, String category) {

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(product);

		WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));

		Select selCategory = new Select(dropdown);

		selCategory.selectByVisibleText(category);

		driver.findElement(By.xpath("//input[@value='Go' and @class='nav-input']")).click();

		String result = driver.findElement(By.xpath("(//span[@data-component-type='s-result-info-bar']//div[@class='sg-col-inner']//span)[1]")).getText();

		return result;
	}

	public String getNthProduct(int itemNumber) {

		String productXpath = String.format("//div[@class='s-result-list s-search-results sg-row']/div[@data-index='%d']",
				(itemNumber));

		return driver.findElement(By.xpath(productXpath)).getText();
	}

	public void printAllProduct() {

		List<WebElement> allProducts = driver
				.findElements(By.xpath("//div[@class='s-result-list s-search-results sg-row']/div"));

		System.out.println("---------------------------------------------------------");
		System.out.println(allProducts.get(8).getText());

		System.out.println("Showing result for " + allProducts.size() + "products");
		for (WebElement product : allProducts) {

			System.out.println("---------------------------------------------------------");
			System.out.println(product.getText());

		}
	}

	public void printAllProductViaScrolldown() {

		List<WebElement> allProducts = driver
				.findElements(By.xpath("//div[@class='s-result-list s-search-results sg-row']/div"));

		Actions action = new Actions(driver);
		
		for (WebElement product : allProducts) {
			
			action.moveToElement(product).build().perform();
			System.out.println("---------------------------------------------------------");
			System.out.println(product.getText());

		}
	}

}
