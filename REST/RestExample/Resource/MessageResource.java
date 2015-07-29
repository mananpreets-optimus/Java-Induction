/*
 * Package Name: com.rest.RestExample.Resource
 */
package com.rest.RestExample.Resource;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import com.rest.RestExample.Model.Message;
import com.rest.RestExample.Service.MessageService;
/*
 * Class Name: MessageResource
 */
@Path("/messages")
public class MessageResource {
	/*
	 * Object of messageService class 
	 */
	MessageService messageService = new MessageService();
	/*
	 * Method Name: getMessages
	 * returns- list of messages
	 */
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessages(){
	
		return messageService.getMessage();
	}
	/*
	 * Method Name: show
	 * returns- message
	 */
	@POST
	@Path("/po")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.TEXT_HTML)
	public String show(String msg){
		String returnString = msg;
		return returnString;
	}
	/*
	 * Method Name: createJsonString
	 * returns- jsonObject as string 
	 */
	@POST
	@Path("/yes")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String createJsonString(String msg) throws JSONException{
		JSONObject obj = new JSONObject(msg);
		String a = obj.getString("message");
		System.out.println("manan   jjjj"+a);
		return a;
	}
	/*
	 * Method Name: createJsonResponse
	 * returns- response 
	 */
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createJsonResponse(JSONObject message) throws JSONException, ParseException{
		
		return Response.status(201).entity("inside").build();
		
	}
	/*
	 * Method Name: getMessageJson
	 * returns- jsonText
	 */
	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public String getMessageJson() throws JSONException{
	
		  JSONObject a = new JSONObject();
		  JSONObject obj=new JSONObject();
		  obj.put("name","foo");
		  obj.put("num",new Integer(100));
		  obj.put("balance",new Double(1000.21));
		  obj.put("is_vip",new Boolean(true));
		  String jsonText = JSONValue.toJSONString(obj);
		  System.out.println(jsonText);
		  return jsonText;
		
	}
	
}

