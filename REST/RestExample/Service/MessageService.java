/*
 * Package Name: com.rest.RestExample.Service
 */
package com.rest.RestExample.Service;

import java.util.ArrayList;
import java.util.List;

import com.rest.RestExample.Model.Message;

/*
 * Class Name: MessageService
 */
public class MessageService {
	List<Message> list = new ArrayList<Message>();
	public List<Message> getMessage(){
		Message m1 = new Message(1,"Hi","Manan");
		Message m2 = new Message(2,"Yo Man","Manan");
		
		list.add(m1);
		list.add(m2);
		return list;
		
	}
}
