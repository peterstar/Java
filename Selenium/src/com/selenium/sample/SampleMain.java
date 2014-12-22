package com.selenium.sample;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SampleMain {
	
	String url = "http://www.google.com";
	WebDriver driver;
	
	@Before
	public void setUp() {
		driver = new FirefoxDriver();		
		driver.get(url);
	}
	
	@Test
	public void testSample() {
		
		String id = "id";
		
		WebElement element = driver.findElement(By.id(id));
		String message = element.getText();
		System.out.println("Message: " + message);
		element.click();
		
		List<WebElement> elements = driver.findElements(By.tagName("a"));
		
		for(WebElement link : elements){
			System.out.println("Link: " + link.getAttribute("a"));
		}
		
		String css = "html body div div form input";
		element = driver.findElement(By.cssSelector(css));
		
		String xpath = "//table[@id='item']/tbody/tr[2]/td";
		element = driver.findElement(By.xpath(xpath));
		Actions builder = new Actions(driver);
		builder.click(elements.get(1)).keyDown(Keys.CONTROL).click(elements.get(3))
			.keyUp(Keys.CONTROL).build().perform();
		
		JavascriptExecutor jsExe = (JavascriptExecutor) driver;
		String script = "return document.title";
		String title = (String) jsExe.executeScript(script);
		
		driver.manage().window().maximize();
		
		Select make = new Select(driver.findElement(By.name("make")));
		make.selectByIndex(0);
		make.selectByValue("value");
		make.selectByVisibleText("text");
		
		String osname = WindowsUtils.readStringRegistryValue("HKEY_LOCAL_MACHINE\\SOFTWARE\\...");
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.titleContains("selenium"));
		
		String parentWindowHandle = driver.getWindowHandle();
		driver.switchTo().window("HelpWindow");
		driver.switchTo().window(parentWindowHandle);
		
		Set<String> allWindows = driver.getWindowHandles();
		if(allWindows.isEmpty())
			Assert.assertFalse(false);
		for(String window : allWindows){
			driver.switchTo().window(window);
			if(driver.getPageSource().contains("title")){
				WebElement button = driver.findElement(By.id("closebutton"));
				button.click();
			}
				
		}
		
		// works same for prompt or any alert box
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		alert.accept();
		
		driver.switchTo().frame("left");
		WebElement twitterFrame = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(twitterFrame);
		driver.switchTo().defaultContent();
		
		
		
	}
		
	@After
	public void tearDown(){
		driver.close();
	}
}