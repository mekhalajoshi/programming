package twoPointers;

import java.util.ArrayList;
import java.util.List;

/***
 * Find the intersection of two sorted arrays. OR in other words, Given 2 sorted
 * arrays, find all the elements which occur in both the arrays.
 * 
 * Example :
 * 
 * Input : A : [1 2 3 3 4 5 6] B : [3 3 5]
 * 
 * Output : [3 3 5]
 * 
 * Input : A : [1 2 3 3 4 5 6] B : [3 5]
 * 
 * Output : [3 5] NOTE : For the purpose of this problem ( as also conveyed by
 * the sample case ), assume that elements that appear more than once in both
 * arrays should be included multiple times in the final output.
 * 
 *
 * .equals NOT == when A.get(mi) is in int range it gets unboxed as int, so ==
 * works but when it is larger than the int range it is treated as an obj. That
 * is why == does not work(Use .equals)
 *
 *
 */
public class IntersectionOfSortedArrays {

	public static ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int mi = 0;
		int ni = 0;
		while (mi < A.size() && ni < B.size()) {
			if (A.get(mi).equals(B.get(ni))) {
				// if (A.get(mi) == (B.get(ni))) {
				result.add(A.get(mi));
				mi++;
				ni++;

			} else if (A.get(mi) > B.get(ni)) {
				ni++;
			} else if (A.get(mi) < B.get(ni)) {
				mi++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		int arr1[] = { 1 };
		// {10000000};
		// {1, 3, 8, 10, 13, 13, 16, 16, 16, 18, 21, 23, 24, 31, 31, 31, 33, 35, 35, 37,
		// 37, 38, 40, 41, 43, 47, 47, 48, 48, 52, 52, 53, 53, 55, 56, 60, 60, 61, 61,
		// 63, 63, 64, 66, 67, 67, 68, 69, 71, 80, 80, 80, 80, 80, 80, 81, 85, 87, 87,
		// 88, 89, 90, 94, 95, 97, 98, 98, 100, 101};
		for (int element : arr1) {
			A.add(element);
		}

		ArrayList<Integer> B = new ArrayList<Integer>();
		int arr2[] = { 1 };
		// {10000000};
		// { 5, 7, 14, 14, 25, 28, 28, 34, 35, 38, 38, 39, 46, 53, 65, 67, 69, 70, 78,
		// 82, 94, 94, 98 };
		for (int element : arr2) {
			B.add(element);
		}
		System.out.println(intersect(A, B));
	}

}
