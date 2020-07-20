package hashing;

/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 < index2. Please note that your returned answers (both index1 and index2 ) are not zero-based. 
Put both these numbers in order in an array and return the array from your function ( Looking at the function signature will make things clearer ). Note that, if no pair exists, return empty list.

If multiple solutions exist, output the one where index2 is minimum. If there are multiple solutions with the minimum index2, choose the one with minimum index1 out of them.

Input: [2, 7, 11, 15], target=9
Output: index1 = 1, index2 = 2
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TwoSum {

	public ArrayList<Integer> twoSum(final List<Integer> A, int B) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < A.size(); i++) {
			if (map.containsKey(B - A.get(i))) {
				result.add(map.get(B - A.get(i)) + 1);
				result.add(i + 1);
				break;
			} else if (!map.containsKey(A.get(i))) {
				map.put(A.get(i), i);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 17, 11, 7, 15 };
		ArrayList<Integer> A = new ArrayList<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i : arr) {
			A.add(i);
		}
		result = new TwoSum().twoSum(A, 9);
		System.out.println(result.get(0));
		System.out.println(result.get(1));
	}

}
