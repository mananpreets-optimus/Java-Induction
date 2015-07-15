package concepts;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListExample {
	
	public static void main(String args[]) {
		
		ArrayList <String> arrayLst = new ArrayList <String>();
		arrayLst.add("Manan");
		arrayLst.add("Java");
		arrayLst.add("Development");
		Iterator<String> itr = arrayLst.iterator();
		while (itr.hasNext()) {
			
			System.out.println(itr.next());
		}
		for (String obj : arrayLst) {
			System.out.println(obj);
		}
	}

}
