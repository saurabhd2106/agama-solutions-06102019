package day1;

import org.openqa.selenium.edge.EdgeDriver;

public class WorkingWithEdge {
	
	EdgeDriver driver;
	
	public void invokeBrowser(){
		
		System.setProperty("webdriver.edge.driver", 
				"C:/Users/Saurabh Dhingra/workspace/libs/MicrosoftWebDriver.exe");
		
		driver = new EdgeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.get("http://qatechhub.com");
	}
	
	public void getTitleOfThePage(){
		System.out.println("Title of the webpage :: "+ driver.getTitle());
	}
	
	public void closeBrowser(){
		// driver.close(); //It closes the current active window
		
		driver.quit(); //It closes all the window opened by selenium
	}

}
