package edu.bethlehem.assignment2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;
import java.util.Vector;

public class CollectionInJava {
	static int N = 5000; 
	static int N2 = 20000;
	static int N3 = 0 ;
	static int test = 0 ;
	public static void main(String[] args)  {
		
		while(N3 <= 900000) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < N; i++)
			list.add(i);
		Collections.shuffle(list); 
		// Shuffle the array list
		
		List<Integer> listTwo = new ArrayList<Integer>();
		for (int i = 0; i < N2; i++)
			listTwo.add(i);
		Collections.shuffle(listTwo); // Shuffle the array list
		
		List<Integer> listThree = new ArrayList<Integer>();
		for (int i = 0; i < N3; i++)
			listThree.add(i);
		Collections.shuffle(listThree); // Shuffle the array list

		// Create a hash set, and test its performance
		Collection<Integer> set1 = new HashSet<Integer>(list); // hashset
		System.out.println("Retrive element time for hash set is " + getTestTime(set1) + " milliseconds");
		System.out.println("Remove element time for hash set is " + getRemoveTime(set1) + " milliseconds");
        System.out.println("----------------");

		// Create a linked hash set, and test its performance
    	Collection<Integer> set2 = new LinkedHashSet<Integer>(list); // linked hash set
		System.out.println("Retrive element time for linked hash set is " + getTestTime(set2) + " milliseconds");
		System.out.println("Remove element time for linked hash set is " + getRemoveTime(set2) + " milliseconds");
		System.out.println("----------------");

		// Create a tree set, and test its performance
		Collection<Integer> set3 = new TreeSet<Integer>(list); // tree set
		System.out.println("Retrive element time for tree set is " + getTestTime(set3) + " milliseconds");
		System.out.println("Remove element time for tree set is " + getRemoveTime(set3) + " milliseconds");
		System.out.println("----------------");

		// Create an array list, and test its performance
		Collection<Integer> list1 = new ArrayList<Integer>(list); // arraylist
		System.out.println("Retrive element time for array list is " + getTestTime(list1) + " milliseconds");
		System.out.println("Remove element time for array list is " + getRemoveTime(list1) + " milliseconds");
		List<Integer> list1b = new ArrayList<Integer>(listTwo);
		List<Integer> list1a = new ArrayList<Integer>(listThree);
     	System.out.println("Traversing all element for array list is "+getTraveringForLoopTime(list1b)+ "milliseconds using for loop"); //
		System.out.println("Traversing all element for array list is "+getTraveringForEachTime(list1a)+ "milliseconds using for each");
		System.out.println("----------------");

		// Create a linked list, and test its performance
		Collection<Integer> list2 = new LinkedList<Integer>(list); // linked list
		System.out.println("Retrive element time for linked list is " + getTestTime(list2) + " milliseconds");
		System.out.println("Remove element time for linked list is " + getRemoveTime(list2) + " milliseconds");
		List<Integer> list2b = new LinkedList<Integer>(listTwo);
		List<Integer> list2a = new LinkedList<Integer>(listThree);
     	System.out.println("Traversing all element for linked list is "+getTraveringForLoopTime(list2b)+ "milliseconds using for loop"); //
		System.out.println("Traversing all element for linked list is "+getTraveringForEachTime(list2a)+ "milliseconds using for each");
		System.out.println("----------------");

		// Create a  priorityQueue, and test its performance
		Collection<Integer> list3 = new PriorityQueue<Integer>(list); // priorityQueue
		System.out.println("Retrive element time for PriorityQueuet is " + getTestTime(list3) + " milliseconds");
		System.out.println("Remove element time for PriorityQueue is " + getRemoveTime(list3) + " milliseconds");
		System.out.println("----------------");

		// Create a  Vector, and test its performance
		Collection<Integer> list4 = new Vector<Integer>(list); // vector
		System.out.println("Retrive element time for vector is " + getTestTime(list4) + " milliseconds");
		System.out.println("Remove element time for vector is " + getRemoveTime(list4) + " milliseconds");
		List<Integer> list4a = new Vector<Integer>(listThree);
		List<Integer> list4b = new Vector<Integer>(listTwo);
    	System.out.println("Traversing all element for vector is "+getTraveringForLoopTime(list4b)+ "milliseconds using for loop"); //
		System.out.println("Traversing all element for vector is "+getTraveringForEachTime(list4a)+ "milliseconds using for each");

		test++;
		N+=5000;
		N2+=20000;
		N3+=100000;
		System.out.println("-------------------> The Test number:"+test);
		list.clear();
		listTwo.clear();
		listThree.clear();
		}
	}

	public static long getTestTime(Collection<Integer> c) {
		long startTime = System.currentTimeMillis();
		// Test if a number is in the collection
		for (int i = 0; i < c.size(); i++)
			c.contains((int) (Math.random() * 2 * N));

		return System.currentTimeMillis() - startTime;
	}

	public static long getRemoveTime(Collection<Integer> c) {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < c.size(); i++)
			c.remove(i);
		return System.currentTimeMillis() - startTime;
	}
	
	public static long getTraveringForLoopTime(List<Integer> c) {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < c.size(); i++) {
			c.get(i);
		}
		return System.currentTimeMillis() - startTime;
	}
	public static long getTraveringForEachTime(List<Integer> c) {
		long startTime = System.currentTimeMillis();
		Iterator<Integer> iterator = c.iterator();
		while(iterator.hasNext()) {
			iterator.next();
		}
		return System.currentTimeMillis() - startTime;
	}		
	
}
