package com.ehcacheExample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;
import net.sf.ehcache.statistics.StatisticsGateway;

/**
 *Class Name: EhcacheExample
 *demo class for ehcache implementation
 *
 */
public class EhcacheExample {

	public static void main(String args[]){
		
		Map<Object,Element> map = new HashMap<Object,Element>();
		List<String> list = new ArrayList<String>();
		
		// Create a cache manager
		CacheManager cacheManager = CacheManager.getInstance();
		
		//Creates a cache called newCache
		cacheManager.addCache("newCache");
		
		//Get cache called newCache
		Cache cache = cacheManager.getCache("newCache");
		StatisticsGateway stats = cache.getStatistics();
		
		//put into cache
		cache.put(new Element("1", "Monday"));
		list.add("1");
		cache.put(new Element("2", "Tuesday"));
		list.add("2");
		cache.put(new Element("3", "Wednesday"));
		list.add("3");
		cache.put(new Element("4", "Thursday"));
		list.add("4");
		
		//Displaying all elements
		System.out.println("All elements");
		map=cache.getAll(list);
		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) {
		     Map.Entry pair = (Map.Entry)it.next();
		     System.out.println(pair.getKey() + " = " + pair.getValue());
		}
		     
		//Displaying elements and size of cache
		Element element = cache.get("1");
		System.out.println("Value of key 1 :"+element.getObjectValue().toString());
		System.out.println("Cache Size "+cache.getSize());
		element = cache.get("2");
		System.out.println("Value of key 2 :"+element.getObjectValue().toString());
		System.out.println("Cache Size "+cache.getSize());
		cache.removeElement(element);
		System.out.println("Cache Size after removing an element : "+cache.getSize());
		cache.flush();
		System.out.println("Removed Cache with key 3 :"+cache.remove("3"));
		System.out.println("Size after remove : "+cache.getSize());
		
		
		
		
	}
}
