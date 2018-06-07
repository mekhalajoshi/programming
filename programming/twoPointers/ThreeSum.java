package twoPointers;
 
import java.util.ArrayList;
import java.util.Collections;

/***
 * Given an array S of n integers, find three integers in S such that the sum is
 * closest to a given number, target. Return the sum of the three integers.
 * 
 * Assume that there will only be one solution
 * 
 * Example: given array S = {-1 2 1 -4}, and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)
 *
 * 
 */
 
public class ThreeSum {

	public int threeSumClosest(ArrayList<Integer> A, int B) {
		 Collections.sort(A);
			int result = A.get(0) + A.get(1) + A.get(2);
			int diff = Math.abs(result - B);
			if (A.size() == 3) {
				return result;
			}
			for (int i = 0; i < A.size() - 2; i++) {
				int m = i;
				int r = A.size() - 1;
				int l = m + 1;
				
				while (l < r) {
				    int sum = A.get(m) + A.get(l) + A.get(r);
					if(sum == B) {
						return B;
					}
					else if ( sum < B) {
						
						l++;
					} else {
						
						r--;
					}
					int newDiff = Math.abs(sum - B);
	                if (newDiff < diff) {
	                    diff = newDiff;
	                    result = sum;
	                }
					if (Math.abs(sum-B	) < result) {
					    result = sum;
				    }
				}
				
			}

			return result;
	    
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> a = new ArrayList<Integer>();
		int[] arr = {5, 2, -2, -5, 10, -1, -6, -3, 5, -8, -7, 2, 5, 4, -1, -5, 0, 5, 0, 2, -5, 1, 4, -10, 2, -1, 4, 1, 6, 0, -10, 8, 4, 5, 5, -7, -3, 6, 10, 6, -5, 5, -1, -3, -2, -7, 8, 3, 10, -5, 10, -2, 0, 9, 7, -1, -2, -8, -1, 2, -8, 10, 4, 0, -10, 0, 4, -5, -4, 2, -1, -8, 10, -2, -1, -6, 0, -1, -2, -7, 3, 7, -9, -2, 4, 7, 0, 2, 10, 2 };
		for (int i : arr) {
			a.add(i);
		}
		System.out.println(new ThreeSum().threeSumClosest(a, 2));
	}

}
