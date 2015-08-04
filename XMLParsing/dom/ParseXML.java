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
/*
 * Class Name: ParseXML
 */
public class ParseXML {
	public static void main(String args[]){
		try{
			/*
			 * New File is created.
			 */
			 File inputFile = new File("input.txt");
			//Create a DocumentBuilder
	         DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder builder = factory.newDocumentBuilder();
	         Document doc = builder.parse(inputFile);
	       //Root Element
	        System.out.println(""+doc.getDocumentElement().getNodeName());
	        NodeList nodeList = doc.getElementsByTagName("student");
	        
	         
	         for(int i = 0; i<nodeList.getLength();i++){
	        	 Node node = nodeList.item(i);
	        	 System.out.println("\nElement :"+node.getNodeName());
	        	 if (node.getNodeType() == Node.ELEMENT_NODE){
	        		 Element element = (Element) node;
	        		 System.out.println("RollNo :"+element.getAttribute("rollno"));
	        		 System.out.println("First Name :"+element.getElementsByTagName("firstname").item(0).getTextContent());
	        		 System.out.println("Last Name :"+element.getElementsByTagName("lastname").item(0).getTextContent());
	        		 System.out.println("Nick :"+element.getElementsByTagName("nickname").item(0).getTextContent());
	        		 System.out.println("Marks :"+element.getElementsByTagName("marks").item(0).getTextContent());
	        	 }
	         }
	       
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
