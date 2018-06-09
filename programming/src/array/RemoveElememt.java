package array;

import java.util.ArrayList;

/***
 * Remove Element
 * 
 * Given an array and a value, remove all the instances of that value in the
 * array. Also return the number of elements left in the array after the
 * operation. It does not matter what is left beyond the expected length.
 * 
 * Example: If array A is [4, 1, 1, 2, 1, 3] and value elem is 1, then new
 * length is 3, and A is now [4, 2, 3] Try to do it in less than linear
 * additional space complexity.
 *
 *
 */
public class RemoveElememt {
	
	public int removeElement(ArrayList<Integer> a, int b) {
		  int n = a.size();
		  int i=0, j=0;
			 for (i=0, j=0; j<n; j++)
		    {
		        if (a.get(j) != b)
		        {
		            a.set(i, a.get(j));
		            i++;
		        }
		    }
		    
		    return i;
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> a = new ArrayList<Integer>();
		int[] arr = {4, 1, 1, 2, 1, 3}; 
		for (int i : arr) {
			a.add(i);
		}
		for (int i=0;i<a.size();i++) {
			System.out.print(a.get(i)+" ");
		}
		System.out.println("");
		System.out.println(new RemoveElememt().removeElement(a, 1));
	}

}
