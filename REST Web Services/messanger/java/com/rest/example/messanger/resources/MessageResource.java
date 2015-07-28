/*
 * Package Name :com.rest.example.messanger.resources
 */
package com.rest.example.messanger.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rest.example.messanger.model.Message;
import com.rest.example.messanger.service.MessageService;
/*
 * Class Name: MessageResource
 * calls getMessages function of MessageService.
 */
@Path("/messages")
public class MessageResource {
	
	MessageService messageService = new MessageService();
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessages(){
	
		return messageService.getMessage();
	}
}
