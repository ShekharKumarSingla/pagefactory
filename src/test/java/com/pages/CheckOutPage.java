package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage {

	
	public static void verifyLabel(WebDriver driver, String Address)
	{
		if(driver.findElement(By.xpath(Address)).isDisplayed())
		{
			System.out.println("Testcase pass");
		}
		else
		{
			System.out.println("Testcase fail");
		}
	}
	
	
}
