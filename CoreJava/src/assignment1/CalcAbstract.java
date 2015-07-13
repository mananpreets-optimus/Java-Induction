/*
 * Package Name: assignment1
 * imports java.lang
 */
package assignment1;
/*
 * Class Name: CalcAbstract 
 * implements interface: CalcInterface
 * Abstract Class which includes two methods calcAbstract and
 * Abstract method countLeaves
 */
public abstract class CalcAbstract implements CalcInterface{
	/*
	 * Method Name: calculateSalary
	 * returns- sum of basic, hra and da as total salary
	 */
	public double calculateSalary(double basic,float hra, float da) {
		return basic+hra+da;
	}
	/*
	 * Method Name: countLeaves
	 * Abstract method
	 */
	public abstract int countLeaves(int TotalLeaveAvailable,int LeavesRequested) throws LeavesGreaterThanExpected;

}
