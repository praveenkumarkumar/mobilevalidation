package org.test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MobileValidation {
	
	static WebDriver driver;
	static long startTime;
	static String name1 ;
	
	@BeforeClass
	public static void BeforeClass() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
		
		}
	
	@AfterClass
	public static void afterClass() {
		driver.quit();
	}
	
	@Before
	public void beforeScript() {
		startTime = System.currentTimeMillis();
	}

	@After
	public void afterScript() {
		long endTime = System.currentTimeMillis();
		System.out.println("Time taken is "+(endTime - startTime));
		
	}
	
	@Test
	public void method1() {
		
			WebElement close = driver.findElement(By.xpath("//button[text( ) ='✕']"));
			close.click();
 }
	@Test
	public void method2() {
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("vivo");
		WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit']"));
		searchButton.click();
		
		}
	@Test
	public void method3() {
		WebElement mobileName = driver.findElement(By.xpath("(//div[contains(text(),'vivo')])[1]"));
		name1 = mobileName.getText();
		System.out.println(name1);

		mobileName.click();
	}
	
	@Test
	public void method4() {
		String parent = driver.getWindowHandle();
		Set<String> children = driver.getWindowHandles();
		
	       for (String x : children) {
	    	   
	    	   if(!parent.equals(x)) {
	    		   driver.switchTo().window(x);
	    	   }
	       }
		
	}
	
	@Test
	public void method5() {
		WebElement mobileName2 = driver.findElement(By.xpath("//button[@type='submit']"));
		String name2 = mobileName2.getText();
		System.out.println(name2);
		
		if (name1.equals(name2)) {
			System.out.println("Pass");
		}else {
			System.out.println("Fail");
		}
	}
	
}
