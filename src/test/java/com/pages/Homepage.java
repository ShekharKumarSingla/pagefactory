package com.pages;

import org.openqa.selenium.WebDriver;

import com.utilitie.Action;

public class Homepage extends Action {

	public static String searchfield =".//*[@id='search-header']";
	public static String searchbutton=".//*[@id='searchGo']";
	public static String mainpage=".//*[@id='ace']";
	
	
	public static void searchProduct(String Product_id, WebDriver driver) throws Exception
	{
		
		setText(driver, searchfield, Product_id);
		click(driver, mainpage);
		click(driver, searchbutton);		
	}
	
	
	
}