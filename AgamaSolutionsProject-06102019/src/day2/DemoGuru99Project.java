package day2;

public class DemoGuru99Project {

	public static void main(String[] args) {

		Guru99Project guru = new Guru99Project();

		guru.invokeBrowser();

		guru.login("mngr201389", "UtAbUbu");

		int count = guru.getLinkCount();

		System.out.println("Count : " + count);
		guru.getAllLinksDetail();

	}

}
