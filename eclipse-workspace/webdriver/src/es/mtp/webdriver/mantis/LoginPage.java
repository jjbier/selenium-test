package es.mtp.webdriver.mantis;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	String baseUrl;
	String username;
	String password;
	
	public LoginPage(WebDriver driver, String baseUrl, String username, String password) 
	{
		this.driver = driver;
		this.baseUrl = baseUrl;
		this.username = username;
		this.password = password;
		
	}
	
	public void run() 
	{
		openPage();
		addUsername(username);
		addPassword(password);
		checkChecks();
		driver.findElement(By.xpath("//input[@value='Iniciar sesión']")).click();
	}
	
	public boolean isLoged() 
	{
		return driver.findElement(By.linkText("Reportar incidencia")) != null;
	}
	
	public void openPage() 
	{
		driver.get(baseUrl + "/login_page.php");		
	}
	
	public void addUsername(String username ) {
		
	    driver.findElement(By.id("username")).clear();
	    driver.findElement(By.id("username")).sendKeys(username);
	    driver.findElement(By.xpath("//input[@value='Iniciar sesión']")).click();	    
	}
	
	public void addPassword(String password) {
		
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys(password);
	    
	}

	public void checkChecks() {
		
	    if (driver.findElement(By.id("remember-login")).getAttribute("checked") != null) {
	    	driver.findElement(By.id("remember-login")).click();
	    }
	    
	  	if (driver.findElement(By.id("secure-session")).getAttribute("checked") != null) {
	    	driver.findElement(By.id("secure-session")).click();
	    }			
	}
	
	
}
