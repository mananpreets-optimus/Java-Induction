/*
 * Package Name: concepts
 */
package concepts;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeSet;
import java.util.Vector;
/*
 * Class Name: CollectionExample
 * includes implementations LinkedList, TreeSet, PriorityQueue, Vector, HashMap
 */
public class CollectionExample {

	public static void main (String args[]) {
		LinkedList <String> listNames = new LinkedList<String>();
		listNames.add("Manan");
		listNames.add("Ravi");
		listNames.add("Ram");
		Iterator<String> itr = listNames.iterator();
		System.out.println("..........LinkedList...........");
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		TreeSet <String> setNames = new TreeSet<String>();
		setNames.add("XML");
		setNames.add("Java");
		setNames.add("Spring");
		setNames.add("Hibernate");
		System.out.println("............TreeSet............");
		Iterator<String> itrSecond = setNames.iterator();
		while(itrSecond.hasNext()) {
			System.out.println(itrSecond.next());
		}
		
		PriorityQueue <String> names = new PriorityQueue<String>();
		names.add("XML");
		names.add("Java");
		names.add("Spring");
		names.add("Hibernate");
		System.out.println("..........ProrityQueue...........");
		Iterator<String> itrThird = names.iterator();
		while(itrThird.hasNext()) {
			System.out.println(itrThird.next());
		}
		
		Vector <String> vectorName = new Vector<String>();
		vectorName.add("XML");
		vectorName.addElement("Java");
		vectorName.add("Spring");
		vectorName.add("Hibernate");
		System.out.println(".............Vector...............");
		Iterator<String> itrFourth = vectorName.iterator();
		while (itrFourth.hasNext()) {
			System.out.println(itrFourth.next());
		}
		
		HashMap<Integer,String> HashMapNames = new HashMap<Integer,String> ();
		HashMapNames.put(1,"Manan");
		HashMapNames.put(2, "Aman");
		System.out.println("");
		for(Map.Entry<Integer, String> hashNames: HashMapNames.entrySet()) {
			System.out.println("Value : "+hashNames.getValue()+" Key : "+hashNames.getKey());
		}
		}
}
