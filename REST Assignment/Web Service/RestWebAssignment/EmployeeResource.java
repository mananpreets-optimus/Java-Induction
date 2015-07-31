/*
 * Package Name : com.optimus.RestWebAssignment
 */
package com.optimus.RestWebAssignment;

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
/*
 * Class Name: EmployeeResource
 */
@Path("/optimus/v1")
public class EmployeeResource {
	EmployeeDAO emp = new EmployeeDAO();
	/*
	 * Get list of employees from database
	 */
	@GET
	@Path("/employeeDetails")
	@Produces(MediaType.APPLICATION_XML)
	public List<Employee> getEmployeeDetails(){
		
		return emp.getEmployeeDetails();
		
	}
	
	/*
	 * Add new Employee to database.
	 */
	
	@POST
	@Path("/addEmployee")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String addEmployee(String jsonText) throws JSONException{
		JSONObject obj=new JSONObject(jsonText);
		emp.addEmployee(obj.get("empName").toString(),obj.get("gender").toString(),obj.get("address").toString(),obj.get("city").toString(),
				obj.get("state").toString(),obj.get("telephone").toString());
		
		JSONObject objReturn=new JSONObject();
		obj.put("message","successfully added");
		String jsonTextReturn = JSONValue.toJSONString(objReturn);
		System.out.println(jsonTextReturn);
		return jsonTextReturn;
		

	}
	/*
	 * Update employee to database
	 */
	@POST
	@Path("/updateEmployee")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String updateEmployee(String jsonText) throws JSONException{
		JSONObject obj=new JSONObject(jsonText);
		emp.updateEmployee(Integer.parseInt(obj.get("id").toString()),obj.get("empName").toString(),obj.get("gender").toString(),obj.get("address").toString(),obj.get("city").toString(),
				obj.get("state").toString(),obj.get("telephone").toString());
		
		JSONObject objReturn=new JSONObject();
		obj.put("message","successfully updated");
		String jsonTextReturn = JSONValue.toJSONString(objReturn);
		System.out.println(jsonTextReturn);
		return jsonTextReturn;
	}
}
