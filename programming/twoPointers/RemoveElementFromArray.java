package twoPointers;

import java.util.ArrayList;

/**
 * 
 * Remove Element
 * 
 * Given an array and a value, remove all the instances of that value in the
 * array. Also return the number of elements left in the array after the
 * operation. It does not matter what is left beyond the expected length.
 * 
 * Example: If array A is [4, 1, 1, 2, 1, 3] 
 * and value elem is 1, then new length is 3, and A is now [4, 2, 3] 
 * 
 * Try to do it in less than linear additional space complexity.
 * 
 *
 */

public class RemoveElementFromArray {

	//efficient code 
	public static int removeElement2(ArrayList<Integer> a, int b) {
		if(a.size()==1 || a.size()==0)
			return a.size();
		int current = 0;
		int count = a.size();
		for(int i=0;i<a.size();i++) {
			if (a.get(i)!=b) {
				a.set(current, a.get(i));
				current++;
			}else {
				count--;
			}
		}
		return count;
	}

	
	public static int removeElement(ArrayList<Integer> a, int b) {

		int front = 0;
		int back = a.size();

		// find first occurrence
		while (front < a.size()) {
			if (a.get(front) == b) {
				back = front;
				break;
			}
			front++;
		}
		// if front is ==b move to next element
		// else copy in back
		while (front < a.size()) {
			if (a.get(front) == b) {
				front++;
			} else {
				a.set(back, a.get(front));
				back++;
				front++;
			}
		}

		return back;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(3);
		a.add(3);
		a.add(4);
		a.add(5);
		a.add(3);
		a.add(7);
		for (int i : a) {
			System.out.print(i);
		}
		System.out.println();
		
		System.out.println(removeElement2(a, 3));
		for (int i : a) {
			System.out.print(i);
		}
	}
}
