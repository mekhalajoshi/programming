package array;

/***
 * Check if there exist two elements in an array whose sum is equal to the sum of rest of the array
 * We have an array of integers and we have to find two such elements in the array such that sum of 
 * these two elements is equal to the sum of rest of elements in array
 * Examples:
 * 
 * Input  : arr[] = {2, 11, 5, 1, 4, 7}
 * Output : Elements are 4 and 11
 * Note that 4 + 11 = 2 + 5 + 1 + 7
 * 
 * Input  : arr[] = {2, 4, 2, 1, 11, 15}
 * Output : Elements do not exist
 * 
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CheckPair {

	public ArrayList<Integer> chkPair(ArrayList<Integer> a) {
		Set<Integer> set = new HashSet<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		int sum = 0;

		if (a == null) {
			return null;
		}

		for (int i = 0; i < a.size(); i++) {
			sum += a.get(i);
		}
		if (sum % 2 != 0) {
			return null;
		}
		sum = sum / 2;

		for (int i = 0; i < a.size(); i++) {
			if (!set.contains(sum - a.get(i))) {
				set.add(a.get(i));
			} else {
				result.add(a.get(i));
				result.add(sum - a.get(i));
				return result;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> a = new ArrayList<Integer>();
		int arr[] = { 2, 11, 5, 1, 4, 7 };
		for (int i : arr) {
			a.add(i);
		}
		ArrayList<Integer> result = new CheckPair().chkPair(a);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}

}
