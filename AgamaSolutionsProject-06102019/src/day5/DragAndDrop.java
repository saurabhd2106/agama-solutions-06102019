package day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver;

		System.setProperty("webdriver.chrome.driver",
				"C:/Users/Saurabh Dhingra/workspace/libs/chromedriver_74/chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.get("https://jqueryui.com/droppable/");

		WebElement frameElement = driver.findElement(By.className("demo-frame"));

		driver.switchTo().frame(frameElement);

		WebElement source = driver.findElement(By.id("draggable"));

		WebElement target = driver.findElement(By.id("droppable"));

		Actions action = new Actions(driver);

		String colorBeforeDragNDrop = target.getCssValue("color");
		// action.dragAndDrop(source, target).build().perform();

		System.out.println(colorBeforeDragNDrop);

		action.moveToElement(source).clickAndHold(source).moveToElement(target).release().build().perform();

		String colorAfterDragNDrop = target.getCssValue("color");

		System.out.println(colorAfterDragNDrop);
	}

}
