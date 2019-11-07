/**
 * 
 * CSCI 230
 * Dr. McCauley
 * HW7
 * Spring 2019
 * 3/7/19
 * @author Jason Adler
 * The class HW7.java contains only a main method for testing purposes.
 *
 * This work is entirely my own, but I did use the internet
 * for help, specifically some tutorial things that I found on geeksforgeeks.org
 */

public class HW7 {

	public static void main (String args[])
	{
		BST<Integer> s = new BST<>();
		
		System.out.println("The height is " + s.height());
		System.out.println("Total leaves are: " + s.countLeafNodes());
	    s.insert(10); 
	    s.insert(2); 
	    s.insert(4); 
	   	 	
	   // System.out.println(s.find(1));
	    
	    System.out.println("The height is " + s.height());
     	//s.remove(6);
	    
	                
		System.out.println("The height is " + s.height());
		
		System.out.println("Total leaves are: " + s.countLeafNodes());
		
		System.out.println("Total depth: " + s.depthOf(4)) ;
	}

}
