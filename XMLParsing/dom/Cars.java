/*
 * Package Name: com.xmlparsing.dom
 */
package com.xmlparsing.dom;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;



import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
/*
 * Class Name: Cars
 * demostration of xml parsing
 */
public class Cars {
	public static void main(String args[]){
		try{
		File inputFile = new File("input3.txt");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(inputFile);
		System.out.println(doc.getDocumentElement().getNodeName());
		
		NodeList nodeList = doc.getElementsByTagName("supercars");
		
		for(int i=0 ; i<nodeList.getLength() ; i++){
			Node node = nodeList.item(i);
			System.out.println(node.getNodeName());
			
		}
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}
}
