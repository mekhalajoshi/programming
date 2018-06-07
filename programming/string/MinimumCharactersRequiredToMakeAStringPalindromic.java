package string;

/**
 * 
 * You are given a string. The only operation allowed is to insert characters in
 * the beginning of the string. How many minimum characters are needed to be
 * inserted to make the string a palindrome string
 * 
 * Example: 
 * 
 * Input: ABC 
 * Output: 2
 * 
 * Input: AACECAAAA 
 * Output: 2
 * 
 * Ask interviewer: case sensitivity
 *
 */
public class MinimumCharactersRequiredToMakeAStringPalindromic {


	public static int solve(String A) {
		int start = 0;
		int end = A.length()-1;
		int count = 0;
		if (A.isEmpty())
			return 0;
		while (start <= end) {
			if(A.charAt(start)==A.charAt(end)) {
				if(!isPalindrome(A.substring(start, end+1))) {
					count++;
					end--;
				}else {
					return A.length()-1-end;
				}
			}else {
				count++;
				end--;
			}
		}
		return count;
	}
	
	private static boolean isPalindrome(String s) {
		int start =0;
		int end =s.length()-1;
		while(start<=end) {
			if(s.charAt(start)==s.charAt(end)) {
				start++;
				end--;
			}else
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println("ABC = "+solve("ABC"));
		System.out.println("AACECAAAAA = "+solve("AACECAAAAA"));
		System.out.println("hqghumeaylnlfdxfi = "+solve("hqghumeaylnlfdxfi"));
	}
}
