/*
 * Package Name: concepts
 */
package concepts;

public class Salary extends EmployeeAbstract{
	
	private float salary;
	/*
	 * Constructor to initialize name, id, address and salary of employee.
	 */
	Salary(String name, int id, String address, float salary) {
		super(name, id, address);
		}
	/*
	 * Method Name: setSalary
	 * sets salary of employee
	 */
	protected void setSalary(float newSalary) {
		salary = newSalary;
	}
	/*
	 * Method Name: getSalary
	 * returns- salary of employee
	 */
	protected float getSalary() {
		return salary;
	}
	/*
	 * (non-Javadoc)
	 * @see concepts.EmployeeAbstract#computeSalary()
	 * Method Name: computeSalary
	 * computes salary of employee and 
	 * returns- salary
	 */
	@Override
	public float computeSalary() {
		System.out.print("Salary of Employee: "+getName()+" Per Month is ");
		return salary/12;
	}
	
	public static void main(String args[]) {
		Salary s = new Salary("Manan", 101, "Optimus Information Noida ", 30000);
		System.out.println(s.computeSalary());
	}

}
