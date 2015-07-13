/*
 * Package Name: assignment1
 * imports java.lang
 */
package assignment1;
/*
 * Class Name: LeavesGreaterThanExpected
 * extends Exception Class to create custom exception
 */
public class LeavesGreaterThanExpected extends Exception {
	
	private static final long serialVersionUID = 1L;
	public LeavesGreaterThanExpected() {
		
	}
	public LeavesGreaterThanExpected(String message) {
		super(message);
	}

}
