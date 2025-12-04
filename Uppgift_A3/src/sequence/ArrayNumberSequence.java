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
	

	public int length() {
		return numbers.length;
		}
	
	
	public double upperBound() {
		double max = numbers[0]; 
		for (int i = 1; i < length(); i++ ){ 
			if (numbers[i] > max) {
				max =  numbers[i];
			}
		}
	return max;
	}
	

	public double lowerBound() {
		double min = numbers[0];
		for (int i = 1; i < length(); i++ ){ 
			if (numbers[i] < min) {
				min =  numbers[i];
			}
		}
	return min;
	}
	

	public double numberAt(int position) throws IndexOutOfBoundsException{
		if(position < 0 || position > length())  
			throw new IndexOutOfBoundsException("OPS! POSITION IS EITHER LESS THAN 0 OR MORE THAN THE LENGTH OF THE SEQUENCE");
		return numbers[position];  
	}
	
		
	public int positionOf(double number) {
		int index = -1; 
		for (int i = 0; i < length(); i++) {  
		       if (numbers[i] == number) {
		            return i;
		        }
		}
		return index; 
	}
		
	
	public boolean isIncreasing() {
		for (int i = 0; i < length() - 1; i++) {
		       if (numbers[i + 1] <= numbers[i])  
		            return false;
		   }
		 return true;
	}
	
	
	public boolean isDecreasing() {
		for (int i=0; i < length() - 1; i++) {
		       if (numbers[i + 1] >= numbers[i]) 
		            return false;
		    }
		return true;
	}
	
		
	public boolean contains(double number) {
		boolean contain = false;
		for (int i = 0; i < length(); i++) { 
			if(numbers[i] == number) {
				contain = true;
				break;
			}		
		}
		return contain;
	}
			
		
	public void add(double number) {
		double[] a = new double[length() + 1]; 
		for (int i = 0; i < length(); i++) {
			a[i] = numbers[i]; 
			}
		a[a.length - 1] = number; 
		numbers = a;
	}
		
	
	public void insert(int position, double number) throws IndexOutOfBoundsException{
		if(position < 0 || position > length())
			throw new IndexOutOfBoundsException("OPS! POSITION IS EITHER LESS THAN 0 OR MORE THAN THE LENGTH OF THE SEQUENCE");  
		double[] a = new double[length() + 1];  
		for (int i = 0; i < position; i++) { 
				a[i] = numbers[i];
			}
		a[position] = number;
		for (int i = position; i < length(); i++) {
				a[i + 1] = numbers[i]; 
			}
		numbers = a;
	}
		
		
	public void removeAt(int position) throws IndexOutOfBoundsException, IllegalStateException{
		if(position < 0 || position > length())
			throw new IndexOutOfBoundsException("OPS! POSITION IS EITHER LESS THAN 0 OR MORE THAN THE LENGTH OF THE SEQUENCE"); 
		if (length() < 2)
			throw new IllegalStateException("not a sequence");
		double[] a = new double[length() - 1];  
		for (int i = 0; i < position; i++) {
			a[i] = numbers[i];  
			}
		for (int i = position; i < length() - 1; i++) {
			a[i] = numbers[i + 1];
			}
		numbers = a;
	}

		
	public double[] asArray() {
		double [] array = new double[length()];   
		for (int i = 0; i < length(); i++) {
			array[i] = numbers[i]; 
			}
		return array;
	}
		
}

