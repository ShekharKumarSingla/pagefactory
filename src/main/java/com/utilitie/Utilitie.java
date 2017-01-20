package com.utilitie;


import java.io.IOException;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Utilitie {

	public static HashMap<String,String> getaddress(String state) throws ParserConfigurationException, SAXException, IOException
	{
		HashMap<String,String> data = new HashMap<String,String>();
		String xmlFile = System.getProperty("user.dir")+"\\src\\main\\Address.xml";
		

		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(xmlFile);
		
		NodeList slist = doc.getElementsByTagName(state);
		NodeList sAddList = slist.item(0).getChildNodes();
		for(int i=0;i<sAddList.getLength();i++)
				{
					Node node = sAddList.item(i);
					if(node.getNodeType() == Node.ELEMENT_NODE)
					{
						System.out.println(node.getNodeName()+"*****"+node.getTextContent());
						data.put(node.getNodeName(),node.getTextContent());
					}
						
				}
		
		
		return data;
		
	}
	
}
