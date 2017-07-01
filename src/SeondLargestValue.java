/*

Write a Program that takes a Collection of Integers as a parameter 
and returns the second largest value in the list. 

*/

import java.util.LinkedList;
import java.util.List;

public class SeondLargestValue {

	List<Integer> list;

	public int findSecondLargest(List<Integer> list) {
		Object[] values = list.toArray();
		int z = 0;
		// loop to order the elements in assending order
		// using bubble sort
		while (z < values.length) {
			for (int i = 1; i < values.length; i++) {
				// comparing the two elements n and n-1 element
				// and swapping if n is greater than n-1 element
				if ((int) values[i] > (int) values[i - 1]) {
					
					int temp = (int) values[i];
					values[i] = values[i - 1];
					values[i - 1] = temp;
				}

			}
			z++;
		}
		// returning the 2nd integer from the array
		// which is 2nd largest in array
		return (int)values[1];
	}

	public static void main(String[] args) {
		SeondLargestValue sf=new SeondLargestValue();
		sf.list = new LinkedList<>();
		sf.list.add(5);
		sf.list.add(10);
		sf.list.add(1);
		sf.list.add(20);
		System.out.println(sf.findSecondLargest(sf.list));

	}

}
