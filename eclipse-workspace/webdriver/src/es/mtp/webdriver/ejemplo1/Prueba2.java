package es.mtp.webdriver.ejemplo1;

import static org.junit.Assert.*;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;;

public class Prueba2 {

	public static void main (String[] args) {
	

		System.setProperty("webdriver.chrome.driver", "/home/xabier/selenium-ide/chromedriver");
		
		// driver = new FirefoxDriver();
		//DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--test-type");
		
		String baseUrl = "http://www.calculadora.net";
		WebDriver driver =  new ChromeDriver(chromeOptions);
		driver.get(baseUrl);
		
	
		CalculadoraTest2 calculadoraTest = new CalculadoraTest2(driver, baseUrl);
		
		String valA = "2";
		String valB = "3";
		
		if (calculadoraTest.suma(valA, valB).equals("5")) {
			System.out.println("Test ok");
		} else {
			System.out.println("Test nok");
		}
		
		driver.close();
	
	
	}
}
class CalculadoraTest2 {
	
	WebDriver driver;
	String baseUrl;
	
	public CalculadoraTest2(WebDriver driver, String baseUrl) {
		
		this.driver = driver;
		this.baseUrl = baseUrl;
	}
	
	public String suma(String valA, String valB) 
	{
	    driver.get(baseUrl);
	    driver.findElement(By.xpath("//input[@value='"+valA+"']")).click();
	    driver.findElement(By.xpath("//input[@value='+']")).click();
	    driver.findElement(By.xpath("//input[@value='"+valB+"']")).click();
	    driver.findElement(By.xpath("//input[@value='=']")).click();
	    return  driver.findElement(By.id("Display")).getAttribute("value");
	}
	
	public String resta(String valA, String valB) 
	{
	    driver.get(baseUrl + "/");
	    driver.findElement(By.xpath("//input[@value='"+valA+"']")).click();
	    driver.findElement(By.xpath("//input[@value='-']")).click();
	    driver.findElement(By.xpath("//input[@value='"+valB+"']")).click();
	    driver.findElement(By.xpath("//input[@value='=']")).click();
	    
	    return driver.findElement(By.id("Display")).getAttribute("value");
	}	
}
