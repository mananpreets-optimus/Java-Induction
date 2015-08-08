package com.restwebservice.RestWsEHCaching;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONValue;


@Path("/optimus/v1")
public class EmployeeResource {
	EmployeeDAO emp = new EmployeeDAO();
	AdminDAO admin = new AdminDAO();
	@POST
	@Path("/employee")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String getEmployeeDetail(String string) throws JSONException{
		System.out.println(string);
		JSONObject obj = new JSONObject(string);
		String stringId = obj.getString("id");
		System.out.println(stringId);
	Integer id = Integer.parseInt(stringId);
	System.out.println(""+id);
		List<Employee> employee = emp.recieveRequest(id);
		ToString ls = new ToString();
		String jsonText = ls.getJson(employee);
		return jsonText;
		
	}
	/*
	 * Get list of employees from database
	 */
	/**
	 * @return jsonText - list of employees
	 */
	@GET
	@Path("/employeeDetails")
	@Produces(MediaType.APPLICATION_JSON)
	public String getEmployeeDetails() {

		List<Employee> employee = emp.getEmployeeDetails();
		ToString ls = new ToString();
		String jsonText = ls.getJson(employee);
		return jsonText;

	}

	/*
	 * Method Name: isAdmin admin authentication.
	 */
	/**
	 * @param jsonText
	 * @return jsonTextReturn - is admin or not
	 * @throws JSONException
	 */
	@POST
	@Path("/isAdmin")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String isAdmin(String jsonText) throws JSONException {

		JSONObject obj = new JSONObject(jsonText);
		JSONObject objReturn = new JSONObject();
		String jsonTextReturn;
		int check = admin.isAdmin(obj.getString("userName"),
				obj.getString("password"));
		if (check == 1) {

			objReturn.put("message", "success");
			jsonTextReturn = JSONValue.toJSONString(objReturn);
			System.out.println(jsonTextReturn);
		} else {
			objReturn.put("message", "failure");
			jsonTextReturn = JSONValue.toJSONString(objReturn);
			System.out.println(jsonTextReturn);
		}
		return jsonTextReturn;

	}

	/*
	 * Add new Employee to database.
	 */

	/**
	 * @param jsonText
	 * @return jsonTextReturn - message successfully added
	 * @throws JSONException
	 */
	@POST
	@Path("/addEmployee")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String addEmployee(String jsonText) throws JSONException {
		JSONObject obj = new JSONObject(jsonText);
		emp.addEmployee(obj.get("empName").toString(), obj.get("gender")
				.toString(), obj.get("address").toString(), obj.get("city")
				.toString(), obj.get("state").toString(), Integer.parseInt(obj
				.get("telephone").toString()));

		JSONObject objReturn = new JSONObject();
		objReturn.put("message", "successfully added");
		String jsonTextReturn = JSONValue.toJSONString(objReturn);
		System.out.println(jsonTextReturn);
		return jsonTextReturn;

	}

	/*
	 * Update employee to database
	 */
	/**
	 * @param jsonText
	 * @return jsonTextReturn - message successfully updated
	 * @throws JSONException
	 */
	@POST
	@Path("/updateEmployee")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String updateEmployee(String jsonText) throws JSONException {
		JSONObject obj = new JSONObject(jsonText);
		emp.updateEmployee(Integer.parseInt(obj.get("id").toString()),
				obj.get("empName").toString(), obj.get("gender").toString(),
				obj.get("address").toString(), obj.get("city").toString(), obj
						.get("state").toString(), obj.get("telephone")
						.toString());

		JSONObject objReturn = new JSONObject();
		objReturn.put("message", "successfully updated");
		String jsonTextReturn = JSONValue.toJSONString(objReturn);
		System.out.println(jsonTextReturn);
		return jsonTextReturn;
	}

}
