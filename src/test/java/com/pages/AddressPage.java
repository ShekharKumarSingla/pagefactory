package com.pages;

import java.io.IOException;
import java.util.HashMap;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.WebDriver;
import org.xml.sax.SAXException;

import com.utilitie.Action;
import com.utilitie.Utilitie;

public class AddressPage extends Action {

	
	public static void filladdress(WebDriver driver,String state) throws ParserConfigurationException, SAXException, IOException, InterruptedException
	{
		HashMap<String,String> address = Utilitie.getaddress(state);
		
		setText(driver, ".//*[@id='billingAddress.address.firstName']", address.get("FirstName"));
		setText(driver, ".//*[@id='billingAddress.address.lastName']", address.get("LastName"));
		setText(driver, ".//*[@id='billingAddress.address.address1']", address.get("Address1"));
		setText(driver, ".//*[@id='billingAddress.address.city']", address.get("City"));
		setText(driver, ".//*[@id='billingAddress.address.state']", address.get("State"));
		setText(driver, ".//*[@id='billingAddress.address.postalCode']", address.get("PostalCode"));
		setText(driver, ".//*[@id='billingAddress.phone']", address.get("Phone"));
		setText(driver, ".//*[@id='billingAddress.emailAddress']", address.get("Email"));
		click(driver, ".//*[@id='addressForm']/button");
		
	
	}
}
