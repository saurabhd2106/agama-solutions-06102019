package day5;

public class DemoAmazonProject {

	public static void main(String[] args) {
		AmazonProject amazon = new AmazonProject();
		
		amazon.invokeBrowser();
		
		amazon.searchProduct("Apple Watch", "Electronics");
		
		amazon.printAllProductViaScrolldown();

	}

}
