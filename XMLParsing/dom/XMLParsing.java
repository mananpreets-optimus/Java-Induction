/*
 * Package Name: com.xmlparsing.dom
 */
package com.xmlparsing.dom;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Document;

/*
 * Class Name: XMLParsing
 * xml parsing example.
 */
public class XMLParsing {
	public static void main(String args[]){
		try{
			//Create a DocumentBuilder
			File inputFile = new File("input.txt");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(inputFile);
			//Root Element
			System.out.println("ROOT ELEMENT: "+doc.getDocumentElement().getNodeName());
			NodeList nodeList = doc.getElementsByTagName("employee");
			
			for(int i = 0; i<nodeList.getLength();i++){
	        	 Node node = nodeList.item(i);
	        	 System.out.println("\nElement :"+node.getNodeName());
	        	 if (node.getNodeType() == Node.ELEMENT_NODE){
				
				Element element = (Element) node;
				System.out.println("Id: "+element.getAttribute("id"));
				System.out.println("First Name"+element.getElementsByTagName("firstname").item(0).getTextContent());
				System.out.println("Certification Status"+element.getElementsByTagName("certification").item(0).getTextContent());
				System.out.println("Nick Name "+element.getElementsByTagName("nickname").item(0).getTextContent());
				}
			}
	
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
