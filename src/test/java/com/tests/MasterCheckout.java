package com.tests;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.AddressPage;
import com.pages.CheckOutPage;
import com.pages.DatabaseConnection;
import com.pages.Getdata;
import com.pages.Homepage;
import com.pages.ProductPage;

public class MasterCheckout {
	
	
	public static String Product_id;
	static WebDriver driver;
	static String url;
	public static String state="IL";
	public static String address=".//*[@id='billingAddress']/legend";
	
	@BeforeTest
	public static void DBdata() throws Exception
	{
		DatabaseConnection.createconnection();
		DatabaseConnection.executeqry();
	}
	
	@BeforeMethod
	public static void initalize() throws Exception
	{
		url=Getdata.geturl("url");
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//pagefactory//Lib//geckodriver.exe");
		driver= new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
	
		
	}
	
	@Test
	public static void master() throws Exception
	{
		Product_id=DatabaseConnection.increment1();
		Homepage.searchProduct(Product_id, driver);
		ProductPage.addtocart(driver);
		Thread.sleep(2000);
		ProductPage.miniCheckout(driver);
		CheckOutPage.verifyLabel(driver, address);
		AddressPage.filladdress(driver, state);
		
	}
	
	@Test(enabled=false)
	public static void visa() throws Exception
	{
		Product_id=DatabaseConnection.increment1();
		Homepage.searchProduct(Product_id, driver);
		ProductPage.addtocart(driver);
		ProductPage.miniCheckout(driver);
		CheckOutPage.verifyLabel(driver, address);
		
	}
	
	
	@AfterMethod
	public static void teardown()
	{
		driver.close();
	}
	
	
	

}
