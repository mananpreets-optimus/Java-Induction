package com.rest.example.messanger.service;

import java.util.ArrayList;
import java.util.List;

import com.rest.example.messanger.model.Message;

public class MessageService {
/*	String message;
	long id;
	String author;*/
	List<Message> list = new ArrayList<Message>();
	public List<Message> getMessage(){
		Message m1 = new Message(1,"Hi","Manan");
		Message m2 = new Message(2,"Yo Man","Manan");
		
		list.add(m1);
		list.add(m2);
		return list;
		
	}
	/*public void addMessage(long id,String message,String author){
		this.id = id;
		this.message = message;
		this.author = author;
		Message msg = new Message(id,message,author);
		list.add(msg);
		
		
	}*/
}
