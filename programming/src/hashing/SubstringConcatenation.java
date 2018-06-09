package hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * You are given a string, S, and a list of words, L, that are all of the same
 * length.
 * 
 * Find all starting indices of substring(s) in S that is a concatenation of
 * each word in L exactly once and without any intervening characters.
 * 
 * Example :
 * 
 * S: "barfoothefoobarman" 
 * L: ["foo", "bar"] 
 * You should return the indices:
 * [0,9]. (order does not matter).
 * 
 * A : "cacbbcabbacccacacaacacbbaccaabcbcbbcabbacc" 
 * B : [ "b", "a", "b", "a", "c", "a", "b" ] 
 * expected value []
 *
 */
public class SubstringConcatenation {

	public static void main(String[] args) {
		List<String> b = new ArrayList<String>();
//		b.add("b");
//		b.add("a");
//		b.add("b");
//		b.add("a");
//		b.add("c");
//		b.add("a");
//		b.add("b");
		b.add("foo");
		b.add("bar");
//		b.add("");
		ArrayList<Integer> result = new ArrayList<Integer>();
		result = findSubstring("barfoothefoobarman",b);
		System.out.print("[");
		for(int i: result) {
			System.out.print(i+",");
		}
		System.out.println("]");
	}

	public static ArrayList<Integer> findSubstring(String a, final List<String> b) {
		int n = (b.size() * b.get(0).length());
		// if (a == null || a.length() < n) {
		// return null;
		// }

		ArrayList<Integer> result = new ArrayList<Integer>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		for (String s : b) {
			if (map.containsKey(s)) {
				int count = map.get(s);
				map.put(s, count + 1);
			} else {

				map.put(s, 1);
			}
		}
		for (int i = 0; i <= a.length() - n; i++) {
			String s = a.substring(i, i + b.get(0).length());
			
			if (map.containsKey(s)) {
				HashMap<String, Integer> tempMap = new HashMap<String, Integer>();
				
				if (i + n <= a.length()) {
					
					for (int j = i; j < i + n; j += b.get(0).length()) {
						s = a.substring(j, j + b.get(0).length());

						if (tempMap.containsKey(s)) {
							tempMap.put(s, tempMap.get(s) + 1);
							
						} else
							tempMap.put(s, 1);
					}
					
					if (map.equals(tempMap)) {
						result.add(i);
					}
					
				}

			}

		}

		return result;

	}
}