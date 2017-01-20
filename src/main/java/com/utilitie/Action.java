package com.utilitie;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Action {
	

	
	public static void click(WebDriver driver, String element) throws InterruptedException
	{
		findElement(driver, element).click();
	}

	public static void dropdownSelectByVisibleText(WebDriver driver, String element, String text2select) throws InterruptedException
	{
		Select dropdownelement = new Select(findElement(driver,element));
		dropdownelement.selectByVisibleText(text2select);
	}
	
	public static void setText(WebDriver driver, String element, String text2set) throws InterruptedException
	{
		findElement(driver,element).sendKeys(text2set);
	}
	
	public static WebElement findElement(WebDriver driver, String xpath) throws InterruptedException
	{
		WebElement element;
		 
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,5);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xpath))));
			element = driver.findElement(By.xpath(xpath));
		}
		catch(StaleElementReferenceException e)
		{
			System.out.println("custom warning: Stale exception detected"+e);
			Thread.sleep(2000);
			element = driver.findElement(By.xpath(xpath));
			
		}
		
		
		
		return element ;
		
	}
	
	public static String getText(WebDriver driver, String xpath)
	{
		return driver.findElement(By.xpath(xpath)).getText();
	}
}
