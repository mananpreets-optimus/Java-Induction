/*
 * Package Name: assignment1
 * imports java.lang
 */
package assignment1;
import java.io.BufferedReader;
/*
 * Class Name:Salary
 * Extends abstract class CalcAbstract
 * includes methods: calculateSalary, overloaded method calculateSalary, leaveRequest
 * and countLeaves
 */
public class Salary extends CalcAbstract {
	
	public static final int MAX_LEAVES=15; //Maximum Leaves cannot be more than 15
	private int leaveRequest = 0; //Leave Requests are initially 0
	/*
	 * (non-Javadoc)
	 * @see assignment1.CalcInterface#calculateSalary()
	 * Method Name: calculateSalary
	 * returns- default salary
	 */
	@Override
	public double calculateSalary() {
		
		return 3000;
	}
	/*
	 * (non-Javadoc)
	 * @see assignment1.CalcAbstract#calculateSalary(double, float, float)
	 * Method Name: calculateSalary
	 * is overloaded method of above calculateSalary 
	 * returns- basic+hra+da as total salary
	 */
	public double calculateSalary(double basic,float hra, float da) {
		return basic + hra + da;
	}
    /*
     * Method Name: leaveRequest
     * returns- Leaves requested by employee
     */
	public int leaveRequest(int LeavesRequested) {
		return (leaveRequest = LeavesRequested);
	}
	/*
	 * (non-Javadoc)
	 * @see assignment1.CalcAbstract#countLeaves(int, int)
	 * Method Name: countLeaves
	 * returns- total leaves left after requesting leaves
	 * it also sends exception if user enter total available leaves greater than 15 
	 * or if leaves requested is greater than total available leaves
	 */
	@Override
	public int countLeaves(int TotalLeavesAvailable, int LeavesRequested) throws LeavesGreaterThanExpected {
		int newLeave = 0;
		try{
			if(TotalLeavesAvailable>MAX_LEAVES) {
				throw new LeavesGreaterThanExpected("Not valid");	
				}
			else {
				if(LeavesRequested>TotalLeavesAvailable) {
					throw new LeavesGreaterThanExpected("Leaves requested>available leaves");
				}
				else{
					return newLeave=TotalLeavesAvailable-LeavesRequested;
				}
			}
		}catch (ArithmeticException ae) {
			System.out.println(ae.getMessage());
		}
		return newLeave;
	}
	
	public static void main(String args[]) throws LeavesGreaterThanExpected {
		int LeavesRequested = 0;
		System.out.println("....................................................");
		Salary sal = new Salary();
		System.out.println("Salary = "+sal.calculateSalary(29000,2900,1000));
		LeavesRequested = sal.leaveRequest(2);
		System.out.println("Leaves Requested = "+LeavesRequested);
		System.out.println("Leaves Left = "+sal.countLeaves(10,LeavesRequested));
		System.out.println("....................................................");
		/*Salary sal2 = new Salary();
		System.out.println("Salary = "+sal2.calculateSalary(20000,1900,800));
		LeavesRequested = sal2.leaveRequest(2);
		System.out.println("Leaves Requested = "+LeavesRequested);
		System.out.println("Leaves Left = "+sal2.countLeaves(20,LeavesRequested));*/
		System.out.println("....................................................");
		Salary sal3 = new Salary();
		System.out.println("Salary = "+sal3.calculateSalary(20000,1900,800));
		LeavesRequested = sal3.leaveRequest(10);
		System.out.println("Leaves Requested = "+LeavesRequested);
		System.out.println("Leaves Left = "+sal3.countLeaves(8,LeavesRequested));
		/*int bas;
		BufferedReader br = new ;
		System.out.println("Enter Basic salary");
		bas=br.read();
		*/
	}

}
