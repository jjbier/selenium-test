package es.mtp.webdriver.ejemplo1;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Prueba2Mantis {

	static WebDriver driver = new FirefoxDriver();
	static String baseUrl = "http://tester.com.es/";
	
	public static void main(String args[]) {
		
	    driver.get(baseUrl + "/login_page.php");
	    driver.findElement(By.id("username")).clear();
	    driver.findElement(By.id("username")).sendKeys("curso-sele");
	    driver.findElement(By.xpath("//input[@value='Iniciar sesión']")).click();
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("sele-julio");
	    if (driver.findElement(By.id("remember-login")).getAttribute("checked") != null) {
	    	driver.findElement(By.id("remember-login")).click();
	    }
	    
	    System.out.println(driver.findElement(By.id("secure-session")).getAttribute("checked"));
	    if (driver.findElement(By.id("secure-session")).getAttribute("checked") != null) {
	    	driver.findElement(By.id("secure-session")).click();
	    }	    
	    
	    driver.findElement(By.xpath("//input[@value='Iniciar sesión']")).click();
	    driver.findElement(By.linkText("Reportar incidencia")).click();
	    new Select(driver.findElement(By.id("category_id"))).selectByVisibleText("Defecto");
	    new Select(driver.findElement(By.id("reproducibility"))).selectByVisibleText("a veces");
	    new Select(driver.findElement(By.id("severity"))).selectByVisibleText("trivial");
	    new Select(driver.findElement(By.id("priority"))).selectByVisibleText("baja");
	    driver.findElement(By.id("platform")).clear();
	    driver.findElement(By.id("platform")).sendKeys("33");
	    driver.findElement(By.id("os")).clear();
	    driver.findElement(By.id("os")).sendKeys("dos");
	    driver.findElement(By.id("os_build")).clear();
	    driver.findElement(By.id("os_build")).sendKeys("123");
	    driver.findElement(By.id("summary")).clear();
	    driver.findElement(By.id("summary")).sendKeys("XabierYMiguel III");
	    driver.findElement(By.id("description")).clear();
	    driver.findElement(By.id("description")).sendKeys("XabierYMiguel II");
	    driver.findElement(By.id("steps_to_reproduce")).clear();
	    driver.findElement(By.id("steps_to_reproduce")).sendKeys("XabierYMiguel II");
	    driver.findElement(By.id("additional_info")).clear();
	    driver.findElement(By.id("additional_info")).sendKeys("XabierYMiguel II");
	    driver.findElement(By.id("tag_string")).clear();
	    driver.findElement(By.id("tag_string")).sendKeys("unas etiquetas");
	    driver.findElement(By.xpath("//input[@value='Enviar incidencia']")).click();
	    driver.findElement(By.linkText("curso-sele")).click();		
	    
	    if (isElementPresent(By.xpath("//div[@class='alert alert-success center']"))) {
	    	System.out.println("OK");
	    } else {
	    	System.out.println("NOK");
	    }
	    
	    driver.findElement(By.partialLinkText("Ver incidencia reportada")).click();
	    driver.findElement(By.xpath("//input[@value='Eliminar']")).click();
	    driver.findElement(By.xpath("//input[@value='Eliminar incidencias']")).click();
	    if (driver.getCurrentUrl().equals("http://tester.com.es/view_all_bug_page.php")) {
	    	System.out.println("OK");
	    } else {
	    	System.out.println("NOK");
	    }
	    
	}
	
	
	  private static boolean isElementPresent(By by) {
		    try {
		      driver.findElement(by);
		      return true;
		    } catch (NoSuchElementException e) {
		      return false;
		    }
		  }	
}
