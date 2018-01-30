package es.mtp.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Calculadora {
	WebDriver driver;
	String baseUrl;
	
	public Calculadora(WebDriver driver, String baseUrl) {
		
		this.driver = driver;
		this.baseUrl = baseUrl;
	}
	
	public String suma(String valA, String valB) 
	{
	    driver.get(baseUrl + "/");
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
