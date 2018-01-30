package es.mtp.webdriver.ejemplo1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GooglePagina {
	
	static WebDriver driver = new FirefoxDriver();
	static String baseUrl = "https://www.google.es";
	
	public static void main (String[] args) throws InterruptedException {
		driver.get(baseUrl + "/");
		
		driver.findElement(By.id("lst-ib")).sendKeys("agile tester");		
		Thread.sleep(2000);
		driver.findElement(By.id("lst-ib")).sendKeys("\n");
		//driver.close();
	}

}
