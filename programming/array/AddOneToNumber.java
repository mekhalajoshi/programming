package array;

import java.util.ArrayList;

/**
 * Given a non-negative number represented as an array of digits,
 * 
 * 
 * add 1 to the number ( increment the number represented by the digits ).
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list.
 * 
 * Example:
 * 
 * If the vector has [1, 2, 3]
 * 
 * the returned vector should be [1, 2, 4]
 * 
 * as 123 + 1 = 124.
 * 
 * NOTE: Certain things are intentionally left unclear in this question which
 * you should practice asking the interviewer. For example, for this problem,
 * following are some good questions to ask : Q : Can the input have 0’s before
 * the most significant digit. Or in other words, is 0 1 2 3 a valid input? A :
 * For the purpose of this question, YES Q : Can the output have 0’s before the
 * most significant digit? Or in other words, is 0 1 2 4 a valid output? A : For
 * the purpose of this question, NO. Even if the input has zeroes before the
 * most significant digit.
 * 
 *
 */
public class AddOneToNumber {

	public ArrayList<Integer> plusOne1(ArrayList<Integer> a) {
	    int i = 0;
        //remove zeroes at the front
        while (i < a.size() - 1 && a.get(i) == 0) {
            a.remove(i);
        }

        int carry = 1;
        int sum;
        for (i = a.size() - 1; i >= 0; i--) {
            sum = a.get(i) + carry;
            a.set(i, sum % 10);
            carry = sum / 10;
            // no need of further processing if carry is zero
            if (carry == 0) {
                break;
            }
        }
        // if carry is still left
        if (carry != 0) {
            a.add(0, carry);
        }
        return a; 
	}
	
	
	public static ArrayList<Integer> plusOne(ArrayList<Integer> a) {
		if (a == null)
			return null;
		int carry = 0;
		for (int i = a.size() - 1; i >= 0; i--) {
			if (a.get(i) == 9) {
				carry = 1;
				a.set(i, 0);
				if (i == 0) {
					a.add(0, 1);
				}
			} else {
				if (carry == 1) {
					a.set(i, a.get(i) + carry);
					carry = 0;
				} else {
					a.set(i, a.get(i) + carry + 1);
				}
				break;
			}
		}
		while (a.get(0) == 0) {
			a.remove(0);
		}
		return a;
	}
	
	
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(8);
		a.add(8);
//		a.add(9);
		plusOne(a);
		for(int i: a) {
			System.out.print(i);
		}
	}
}
