package math;

/*
 * Determine whether an integer is a palindrome. Do this without extra space.

A palindrome integer is an integer x for which reverse(x) = x where reverse(x) is x with its digit reversed.
Negative numbers are not palindromic.

Example :

Input : 12121
Output : True

Input : 123
Output : False
 */
public class PalindromeInteger {
	public static boolean isPalindrome(int a) {
		//negative numbers
		if(a<0)
			return false;
		//single digit numbers are palindromes
		if(a<10)
			return true;
		
		//convert number to String
		String s = Integer.toString(a);
		
		int start =0;
		int end = s.length()-1;
		
		while(start<end) {
			if(s.charAt(start)!=s.charAt(end)) {
				return false;
			}else {
				start++;
				end--;
			}
		}
		return true;
	}

	public static boolean isPalindrome2(int a) {
		if(a>=0&&a<9)
	        return true;
	    if(a<0)
	        return false;   
	    String s =String.valueOf(a);
	    boolean palindrome = true;
	    for(int i=0; i<=(s.length()-1)/2;i++){
	        if(s.charAt(i)!=s.charAt(s.length()-1-i)){
	            palindrome = false;
	            break;
	        }
	    }
	    return palindrome;
	}
	
	//InterviewBit Solution
	public static boolean isPalindrome3(int a) {
	    if(a == check(a))
	        return true;
	    else
	        return false;
	}
	
	public static int check(int num){
        int reverted = 0;
        while (num > 0) {
            reverted = reverted*10 + num%10;
            num /= 10;
        }
      return reverted;
	}
	
	public static void main(String[] args) {
		System.out.println(isPalindrome2(12321));
	}

}
