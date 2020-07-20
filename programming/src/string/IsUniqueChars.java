package string;

/***
 * Implement an algorithm to determine if a string has all unique characters 
 * What if you can not use additional data structures? --n^2 Solution
 */
import java.util.HashSet;

public class IsUniqueChars {

	public boolean isUniqueChars(String s) {
		if (s == null) {
			return false;
		}
		HashSet<Character> set = new HashSet<Character>();
		// boolean isUnique = true;
		for (char c : s.toCharArray()) {
			if (set.contains(c)) {
				return false;
			} else {
				set.add(c);
			}

		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println("ABC " + new IsUniqueChars().isUniqueChars("ABC"));
		System.out.println("aaa " + new IsUniqueChars().isUniqueChars("aaa"));
		System.out.println("b..a " + new IsUniqueChars().isUniqueChars("b..a"));
		System.out.println("b.a " + new IsUniqueChars().isUniqueChars("b.a"));
	}

}
