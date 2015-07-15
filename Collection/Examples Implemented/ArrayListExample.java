/*
 * Package Name: concepts
 */
package concepts;

import java.util.ArrayList;
import java.util.Iterator;
/*
 * Class Name: ArrayListExample
 * involves simple ArrayList.
 */
public class ArrayListExample {
	
	public static void main(String args[]) {
		
		ArrayList <String> arrayLst = new ArrayList <String>();
		arrayLst.add("Manan");
		arrayLst.add("Java");
		arrayLst.add("Development");
		Iterator<String> itr = arrayLst.iterator();
		/*
		 * Iteration of arrayList
		 * using Iterator instance.
		 */
		while (itr.hasNext()) {
			
			System.out.println(itr.next());
		}
		/*
		 * Iteration of arrayList
		 * using for each loop.
		 */
		for (String obj : arrayLst) {
			System.out.println(obj);
		}
	}

}
