package com.pages;

import org.openqa.selenium.WebDriver;

import com.utilitie.Action;

public class ProductPage extends Action {

	public static String product_qty=".//*[@id='quantity']";
	public static String AddtoCart=".//*[@id='quantAddToCart']/button";
	public static String miniChkout=".//*[@id='miniCheckoutNow']";
	public static String fullChkout=".//*[@id='miniViewFullCart']";
	
	
	public static void updateQuantity(WebDriver driver, String productQuantity) throws InterruptedException
	{
		setText(driver, product_qty, productQuantity);
	}
	
	public static void addtocart(WebDriver driver) throws InterruptedException
	{
	   click(driver, AddtoCart);
	}
	
	public static void miniCheckout(WebDriver driver) throws InterruptedException
	{
		click(driver,miniChkout);
	}
	
	public static void fullCheckout(WebDriver driver) throws InterruptedException
	{
		click(driver,fullChkout);
	}
}
