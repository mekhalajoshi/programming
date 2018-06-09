package string;

/***
 * Given a string s consists of upper/lower-case alphabets and empty space
 * characters ' ', return the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space
 * characters only.
 * 
 * Example:
 * 
 * Given s = "Hello World",
 * 
 * return 5 as length("World") = 5.
 * 
 * Please make sure you try to solve this problem without using library
 * functions. Make sure you only traverse the string once.
 *
 */
public class LengthofLastWord {
	
	public static int lengthOfLastWord(final String A) {
		if(A.length()==0)
			return 0;
		int count=0;
		int lastCount=0;
		for(int i=0;i<A.length();i++) {
			if(A.charAt(i)==' ') {
			    if(count!=0)
				    lastCount = count;
				count =0;
			}else {
				count++;
			}
		}
		return count==0 ? lastCount : count;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("abc a"+" = "+lengthOfLastWord("abc a"));
		System.out.println("  "+" = "+lengthOfLastWord("   "));
		System.out.println(" a"+" = "+lengthOfLastWord(" a"));
		System.out.println("abc a  "+" = "+lengthOfLastWord("abc a  "));
	}

}
