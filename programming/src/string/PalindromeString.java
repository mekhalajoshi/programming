package string;
/**
 * 
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Example:

"A man, a plan, a canal: Panama" is a palindrome.

"race a car" is not a palindrome.

Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 * 
 * @author MJ
 *
 */
public class PalindromeString {

	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
	}
	public static int isPalindrome(String a) {
	    int n = a.length();
	    a = a.toLowerCase();
	    StringBuilder str = new StringBuilder();
	    for(int i=0;i<n;i++){
	        if(Character.isLetterOrDigit(a.charAt(i))&&a.charAt(i)!=' '){
	            str.append(a.charAt(i));
	        }
	    }
	    a = str.toString();
	    n = a.length();
	    for(int i=0;i<n/2;i++){
	        if(Character.isLetterOrDigit(a.charAt(i))){
	            if (a.charAt(i) != a.charAt(n - i - 1)) {
                    return 0;
                }
	        }
	    }
	    
	        return 1;
	}
}
