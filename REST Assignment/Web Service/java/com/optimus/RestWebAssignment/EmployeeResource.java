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
 * includes methods getEmployeeDetails, isAdmin, addEmployee, updateEmployee
 */
@Path("/optimus/v1")
public class EmployeeResource {
	EmployeeDAO emp = new EmployeeDAO();
	AdminDAO admin = new AdminDAO();
	/*
	 * Get list of employees from database
	 */
	@GET
	@Path("/employeeDetails")
	@Produces(MediaType.APPLICATION_JSON)
	public String getEmployeeDetails(){
		
		List<Employee> employee = emp.getEmployeeDetails();
		ListToString ls = new ListToString();
		String jsonText = ls.getJson(employee);
		return jsonText;
		
	}
	/*
	 * Method Name: isAdmin
	 * admin authentication.
	 */
	@POST
	@Path("/isAdmin")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String isAdmin(String jsonText) throws JSONException{
		
		JSONObject obj=new JSONObject(jsonText);
		JSONObject objReturn=new JSONObject();
		String jsonTextReturn;
		int check = admin.isAdmin(obj.getString("userName"), obj.getString("password"));
		if(check == 1){
			
			objReturn.put("message","success");
			jsonTextReturn = JSONValue.toJSONString(objReturn);
			System.out.println(jsonTextReturn);
		}
		else{
			objReturn.put("message","failure");
			jsonTextReturn = JSONValue.toJSONString(objReturn);
			System.out.println(jsonTextReturn);
		}
		return jsonTextReturn;
		
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
		objReturn.put("message","successfully added");
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
		objReturn.put("message","successfully updated");
		String jsonTextReturn = JSONValue.toJSONString(objReturn);
		System.out.println(jsonTextReturn);
		return jsonTextReturn;
	}
}
