package project;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Acme {
@Test
	public void runAcme()throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://acme-test.uipath.com/account/login");
		driver.findElementById("email").sendKeys("kumar.testleaf@gmail.com");
		driver.findElementById("password").sendKeys("leaf@12");
		driver.findElementById("buttonLogin").click();
		Thread.sleep(2000);
		WebElement button6 = driver.findElementByXPath("//button[text()[normalize-space()='Invoices']]");
		Actions builder =new Actions(driver);
		builder.click(button6);
		builder.perform();
		driver.findElementByLinkText("Search for Invoice").click();
		driver.findElementById("vendorTaxID").sendKeys("DE763212");
		driver.findElementById("buttonSearch").click();
		driver.findElementByXPath("(//td[text()='IT Support'])[1]").getText();
		List<WebElement> rows = driver.findElementsByXPath("//table[@class='table']//tr");
		int rowsize =rows.size();
		for(int i=2;i<rowsize;i++) {
			String text = driver.findElementByXPath("//table[@class='table']//tr["+i+"]/td[3]").getText();
			if(text.equals("IT Support")) {
				String text2 =driver.findElementByXPath("//table[@class='table']//tr["+i+"]/td[1]").getText();
				System.out.println(text2);
			}			
		}
driver.findElementByLinkText("Log Out").click();
driver.close();
   
	}

}
