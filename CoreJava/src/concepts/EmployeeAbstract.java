/*
 * Package Name: concepts
 */
package concepts;
/*
 * Class Name: Employee
 * Employee is abstract class 
 * Includes fields: name, id, address
 * Includes methods: getId, getName, setId, getAddress, setAddress
 */
public abstract class EmployeeAbstract {
	private String name;
	private int id;
	private String address;
	/*
	 * Constructor to initialize name, id and address of employee. 
	 */
	EmployeeAbstract(String name, int id, String address) {
		this.name = name;
		this.id = id;
		this.address = address;
	}
	
	/*
	 * Function Name: getId
	 * returns -id of Employee
	 */
	public int getId() {
		return id;
	}
	/*
	 * Function Name: getName
	 * returns -name of Employee
	 */
	public String getName() {
		return name;
	}
	/*
	 * Function Name: setId
	 * sets id of Employee
	 */
	public void setId(int newId) {
		id = newId;
	}
	/*
	 * Function Name: getAddress
	 * sets name of Employee 
	 */
	public String getAddress() {
		return address;
	}
	/*
	 * Function Name: setAddress
	 * sets address of Employee 
	 */
	public void setAddress(String newAddress) {
		address = newAddress;
	}
	/*
	 * Function Name: computeSalary
	 * abstract method;
	 */
	public abstract float computeSalary();
	
}
