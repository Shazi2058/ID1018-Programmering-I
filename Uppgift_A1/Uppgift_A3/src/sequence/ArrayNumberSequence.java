package sequence;

import sequence.LinkedNumberSequence.Node;

//ArrayNumberSequence.java

/****************************************************************

ArrayNumberSequence represents a sequence of real numbers.
Such a sequence is defined by the interface NumberSequence.
The class uses an array to store the numbers in the sequence.

Author
Fadil Galjic

****************************************************************/

public class ArrayNumberSequence implements NumberSequence
{
	// numbers in the sequence
 private double[] numbers;

 // create the sequence
 public ArrayNumberSequence (double[] numbers)
 {
		if (numbers.length < 2)
		    throw new IllegalArgumentException("not a sequence");

		this.numbers = new double[numbers.length];
		for (int i = 0; i < numbers.length; i++)
		    this.numbers[i] = numbers[i];
	}

 // toString returns the character string representing this
 // sequence
	public String toString ()
	{
		String s = "";
		for (int i = 0; i < numbers.length - 1; i++)
		    s = s + numbers[i] + ", ";
		s = s + numbers[numbers.length - 1];

		return s;
	}

 // add code here
	
	// Length
	public int length() {
		return numbers.length;
		}
	
	// upper
	public double upperBound() {
		double max = numbers[0]; //assume first number from sequence is max
		for (int i = 1; i < length(); i++ ){  //goes through each number comparison and put max into the largest number in sequence
			if (numbers[i] > max) {
				max =  numbers[i];
			}
		}
	return max;
	}
	
	// Lower
	public double lowerBound() {
		double min = numbers[0];//assume first number from sequence is min
		for (int i = 1; i < length(); i++ ){ //goes through each number comparison and put max into the smallest number in sequence
			if (numbers[i] < min) {
				min =  numbers[i];
			}
		}
	return min;
	}
	
	// number At
		public double numberAt(int position) throws IndexOutOfBoundsException{
			if(position < 0 || position > length()) // If the position user want is less than zero or more than length then it give exception 
				throw new IndexOutOfBoundsException("OPS! POSITION IS EITHER LESS THAN 0 OR MORE THAN THE LENGTH OF THE SEQUENCE");
			return numbers[position]; // return number at position asked for 
		}
		
		// Position
		public int positionOf(double number) {
			int index = -1; // -1 counts as not founded
			for (int i = 0; i < length(); i++) { // if the number is in sequence it returns 0 which mean founded 
		        if (numbers[i] == number) {
		            return i;
		        	}
				}
			return index; // Return -1 when not founded
			}
		
		//isIncreasing
		public boolean isIncreasing() {
			for (int i = 0; i < length() - 1; i++) {
		        if (numbers[i + 1] <= numbers[i]) // Checks if the next number is less or = than current number if yes then return false 
		            return false;
		    }
		    return true;
		}
		//isDecreasing
		public boolean isDecreasing() {
			for (int i=0; i < length() - 1; i++) {
		        if (numbers[i + 1] >= numbers[i])// Checks if the next number is more or = than current number if yes then return false 
		            return false;
		    }
		    return true;
		}
	
		// Contain 
		public boolean contains(double number) {
			boolean contain = false;
			for (int i = 0; i < length(); i++) { // Checks if the given number is in the sequence, if yes then return true and breaks the loop
				if(numbers[i] == number) {
				contain = true;
				break;
				}		
			}
			return contain;
		}
			
		
		//add 
		public void add(double number) {
			double[] a = new double[length() + 1]; // making new array storage/address with one more storage
			for (int i = 0; i < length(); i++) {
				a[i] = numbers[i]; // copying every number into the new address
				a[a.length - 1] = number; // add the given number at last
				numbers = a;
				}
		}
		
		//insert
		public void insert(int position, double number) throws IndexOutOfBoundsException{
			if(position < 0 || position > length())
				throw new IndexOutOfBoundsException("OPS! POSITION IS EITHER LESS THAN 0 OR MORE THAN THE LENGTH OF THE SEQUENCE"); // If the position user want is less than zero or more than length then it give exception 
			double[] a = new double[length() + 1]; // making new array storage/address with one more storage /length 
			for (int i = 0; i < position; i++) { // copying every number into the new address till 1 less position number
				a[i] = numbers[i];
				}
			a[position] = number; // add the number in the position
			for (int i = position; i < length(); i++) {
				a[i + 1] = numbers[i]; // copying every number into the new address after position till less than length.
				}
			numbers = a;
		}
		
		
		//Remove 
		public void removeAt(int position) throws IndexOutOfBoundsException, IllegalStateException{
			if(position < 0 || position > length())
				throw new IndexOutOfBoundsException("OPS! POSITION IS EITHER LESS THAN 0 OR MORE THAN THE LENGTH OF THE SEQUENCE"); // If the position user want is less than zero or more than length then it give exception
			if (length() < 2)
			    throw new IllegalStateException("not a sequence");// If the sequence have 2 or less length then it give exception saying that it is not a sequence
		
			double[] a = new double[length() - 1]; //making new array storage/address with one less storage/length 
			for (int i = 0; i < position; i++) {
				a[i] = numbers[i]; //copying every number into the new address till 1 less position number 
				}
			for (int i = position; i < length() - 1; i++) {
				a[i] = numbers[i + 1]; //copying every after number into the new address from position (excluding position number) number till new length
				}
			numbers = a;
		}

		
		//asArray
		public double[] asArray() {
			double [] array = new double[length()]; //making new array storage/address with same length  
			for (int i = 0; i < length(); i++) {
				array[i] = numbers[i]; // Copies all the new number from old to new array
				}
			return array;
		}
		
	}

