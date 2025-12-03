package sequence;

//LinkedNumberSequence.java

/****************************************************************

LinkedNumberSequence represents a sequence of real numbers.
Such a sequence is defined by the interface NumberSequence.
The class uses linked nodes to store the numbers in the sequence.

Author
Fadil Galjic

****************************************************************/

public class LinkedNumberSequence implements NumberSequence
{
	public class Node
	{
		public double number;
		public Node next;

		public Node (double number)
		{
			this.number = number;
			next = null;
		}
	}

	// the first node in the node-sequence
 private Node first;

 // create the sequence
 public LinkedNumberSequence (double[] numbers)
 {
		if (numbers.length < 2)
		    throw new IllegalArgumentException("not a sequence");

     first = new Node(numbers[0]);
     Node n = first;
		for (int i = 1; i < numbers.length; i++)
		{
			n.next = new Node(numbers[i]);
			n = n.next;
		}
	}

 // toString returns the character string representing this
 // sequence
	public String toString ()
	{
		String s = "";
		Node n = first;
		while (n.next != null)
		{
		    s = s + n.number + ", ";
		    n = n.next;
		}
		s = s + n.number;

		return s;
	}

 // add code here
	// Length
	public int length() {
		int length = 0; // starts with making length 0
		Node n = first; // starts from first node 
		while(n != null) { // Count length by going through n till n become null 
			length++; 
			n = n.next; // goes to next node 
		}
		return length;
	}
	
	// upperBound
	public double upperBound() {
		Node n = first; // starts from first node 
		double upper = n.number;  // Assume the first number is max
		while(n!=null) { // loops till n become null and compare which one is biggest
			if ( n.number > upper)
				upper= n.number; // store bigger number in upper
			n = n.next;
		}
	return upper;
	}
	
	// lowerBound 
	public double lowerBound() {
		Node n = first; // starts from first node 
		double lower = n.number; // Assume the first number is min
		while(n!=null) { // loops till n become null and compare which one is smallest
			if ( n.number < lower)
				lower= n.number; // store smaller number in upper
			n = n.next;
		}
	return lower;
	}
	
	// number At
	public double numberAt(int position) throws IndexOutOfBoundsException{
		if(position < 0 || position > length())
			throw new IndexOutOfBoundsException("OPS! POSITION IS EITHER LESS THAN 0 OR MORE THAN THE LENGTH OF THE SEQUENCE");  // If the position user want is less than zero or more than length then it give exception 
		Node n = first; // starts from first node
		for (int i = 0; i < position; i++) {  // loops till position and get number from position
			n = n.next;
		}
		return n.number;
	}
	
	
	// Position
	public int positionOf(double number) {
		Node n = first; // starts from first node
		int searching = 0; 
		while (n != null) { // goes trough all nodes
			if(n.number == number){ // found then returning 0
				return searching;
			}
			searching++;
			n = n.next;
		}
		return -1; // not found returning -1
	}
		
		

	// increaing
	public boolean isIncreasing() {
		for (Node n = first; n.next != null; n = n.next) { // starts from first node and goes through every nodes 
	        if (n.next.number <= n.number) { // check if the next numbers not bigger than old number or if it is not increasing returning false
	            return false;  
	            }
	    }
	    return true;
	}
	
	
	// Decreaing
	public boolean isDecreasing() {
		for (Node n = first; n.next != null; n = n.next) {
	        if (n.next.number >= n.number) { // check if the next numbers not smaller than old number or if it is not decreasing returning false
	            return false;
	            }
	    }
	    return true;
	}
	
	// Contain
	public boolean contains(double number) {
		Node n = first; // Starts from first node 
		boolean contain = false; // lets say it is false 
		while (n != null) { // Goes through every node till it is null
			if(n.number == number) { // Check if given number is = to numbers from nodes 
				contain = true;
				break; // Break the loop
			}
			n = n.next;
		}
		return contain;
	}
	
	// Add
	public void add(double number) {
		Node n = first; // Starts from first node
		while (n.next != null) // Goes through every node till it is null
			n = n.next;
			n.next = new Node(number); //adding another number i new node 
	}
	
	// Insert
	public void insert(int position, double number) throws IndexOutOfBoundsException{
		if(position < 0 || position > length())
			throw new IndexOutOfBoundsException("OPS! POSITION IS EITHER LESS THAN 0 OR MORE THAN THE LENGTH OF THE SEQUENCE"); // If the position user want is less than zero or more than length then it give exception
		Node node = new Node(number); 
		if(position == 0) {
			first = first.next;
		}
		else {
			Node n = first;
			for (int i = 1; i < position; i++) // Find the node before give new value to it 
				n = n.next;
			node.next = n.next;  // Insert new node and new node points to n next then n points to new node
			n.next = node;
		}
	}
	// Remove
	
	public void removeAt(int position) throws IndexOutOfBoundsException, IllegalStateException{
		if(position < 0 || position >= length())
			throw new IndexOutOfBoundsException("OPS! POSITION IS EITHER LESS THAN 0 OR MORE THAN THE LENGTH OF THE SEQUENCE"); // If the position user want is less than zero or more than length then it give exception
		Node n = first;
		if (length() < 2)
			throw new IllegalStateException("OPS! Only 2 number there."); // If the length is less than 2 then it is not a sequence
		
		for (int i = 0; i < position; i++) {
			n = n.next;
			}
			n.next = n.next.next;
	}
	
	
	// asArray
	public double[] asArray() {
		double [] array = new double[length()];
		int index = 0;
		Node n = first;
		while (n != null) {
			array[index] = n.number;
			n = n.next;
			index++;
		}
		return array;
	
	}
}
