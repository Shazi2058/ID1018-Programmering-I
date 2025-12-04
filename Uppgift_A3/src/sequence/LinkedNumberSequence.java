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

	public int length() {
		int length = 0; 
		Node n = first;  
		while(n != null) {  
			length++; 
			n = n.next;  
		}
		return length;
	}
	

	public double upperBound() {
		Node n = first;  
		double upper = n.number; 
		while(n!=null) { 
			if ( n.number > upper)
				upper= n.number;
			n = n.next;
		}
	return upper;
	}
	

	public double lowerBound() {
		Node n = first;  
		double lower = n.number;
		while(n!=null) { 
			if ( n.number < lower)
				lower= n.number; 
			n = n.next;
		}
	return lower;
	}
	

	public double numberAt(int position) throws IndexOutOfBoundsException{
		if(position < 0 || position > length())
			throw new IndexOutOfBoundsException("OPS! POSITION IS EITHER LESS THAN 0 OR MORE THAN THE LENGTH OF THE SEQUENCE");  
		Node n = first; 
		for (int i = 0; i < position; i++) {  
			n = n.next;
		}
		return n.number;
	}
	

	public int positionOf(double number) {
		Node n = first; 
		int searching = 0; 
		while (n != null) { 
			if(n.number == number){ 
				return searching;
			}
			searching++;
			n = n.next;
		}
		return -1; 
	}
		

	public boolean isIncreasing() {
		for (Node n = first; n.next != null; n = n.next) {  
	        if (n.next.number <= n.number) {
	            return false;  
	            }
	    }
	    return true;
	}
	

	public boolean isDecreasing() {
		for (Node n = first; n.next != null; n = n.next) {
	        if (n.next.number >= n.number) { 
	            return false;
	            }
	    }
	    return true;
	}
	

	public boolean contains(double number) {
		Node n = first;  
		boolean contain = false;  
		while (n != null) { 
			if(n.number == number) {  
				contain = true;
				break; // 
			}
			n = n.next;
		}
		return contain;
	}
	

	public void add(double number) {
		Node n = first; 
		while (n.next != null) 
			n = n.next;
			n.next = new Node(number); 
	}
	

	public void insert(int position, double number) throws IndexOutOfBoundsException{
		if(position < 0 || position > length())
			throw new IndexOutOfBoundsException("OPS! POSITION IS EITHER LESS THAN 0 OR MORE THAN THE LENGTH OF THE SEQUENCE"); 
		Node node = new Node(number); 
		if(position == 0) {
			node.next = first;	
			first = node;
		}
		else {
			Node n = first;
			for (int i = 1; i < position; i++)  
				n = n.next;
			node.next = n.next;  
			n.next = node;
		}
	}

	
	public void removeAt(int position) throws IndexOutOfBoundsException, IllegalStateException{
		if(position < 0 || position > length())
			throw new IndexOutOfBoundsException("OPS! POSITION IS EITHER LESS THAN 0 OR MORE THAN THE LENGTH OF THE SEQUENCE"); 
		Node n = first;
		if (length() < 2)
			throw new IllegalStateException("OPS! Only 2 number there."); 
		if(position == 0)
			first = first.next;
			
		for (int i = 0; i < position; i++) {  
			n = n.next;    
			}
			n.next = n.next.next;
	}
	

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
