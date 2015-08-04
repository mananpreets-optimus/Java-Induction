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
 * Class Name: XmlParsingExample
 * parsing of xml file input2.txt
 */
public class XmlParsingExample {
	public static void main(String args[]){
		try{
		File inputFile = new File("input2.txt");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(inputFile);
		System.out.println("ROOT ELEMENT: "+doc.getDocumentElement().getNodeName());
		NodeList nodeList = doc.getElementsByTagName("followerSet");
		
		for(int i=0 ; i<nodeList.getLength() ; i++){
			Node node = nodeList.item(i);
			System.out.println(node.getNodeName());
			
			if(node.getNodeType() == Node.ELEMENT_NODE){
				Element element = (Element) node;
				
				//System.out.println(element.getElementsByTagName("followers").item(0).getNodeName());
				System.out.println(element.getElementsByTagName("followers").item(0).getTextContent());
		
			}
		}
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}
}
