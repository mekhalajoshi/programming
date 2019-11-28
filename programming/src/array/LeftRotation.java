package array;

import java.util.ArrayList;
import java.util.List;

/***
 * A left rotation operation on an array of size  shifts each of the array's elements  unit to the left. For example, if  left rotations are performed on array , then the array would become .

Given an array of  integers and a number, , perform  left rotations on the array. Then print the updated array as a single line of space-separated integers.

Input Format

The first line contains two space-separated integers denoting the respective values of  (the number of integers) and  (the number of left rotations you must perform).
The second line contains  space-separated integers describing the respective elements of the array's initial state.

Constraints

Output Format

Print a single line of  space-separated integers denoting the final state of the array after performing  left rotations.

Sample Input

5 4
1 2 3 4 5
Sample Output

5 1 2 3 4
Explanation

When we perform  left rotations, the array undergoes the following sequence of changes:

Thus, we print the array's final state as a single line of space-separated values, which is 5 1 2 3 4.
 *
 *
 */
public class LeftRotation {
	
		public static void leftRotate(final List<Integer> a, int n, int d) {
			int number_of_rotations = d%n;

	        for(int i= number_of_rotations; i<a.size(); i++){
	            System.out.print(a.get(i));
	            System.out.print(" ");
	        }
	        for(int i=0; i< number_of_rotations; i++){
	            System.out.print(a.get(i));
	            System.out.print(" ");
	        }
		}
	
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		a.add(5);
//		a.add(3);
//		a.add(3);
//		a.add(1);
//		a.add(3);
//		a.add(7);
		for (int i : a) {
			System.out.print(i);
		}
		System.out.println();
		System.out.println();
		System.out.println();
		leftRotate(a,5,7);
		leftRotate(a,5,2);
	}
}
