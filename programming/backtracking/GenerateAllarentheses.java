package backtracking;

import java.util.ArrayList;

/***
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*n.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
Make sure the returned list of strings are sorted.
 *
 */

public class GenerateAllarentheses {

	public static ArrayList<String> generateParenthesis(int A) {
		ArrayList<String> result = new ArrayList<String>();
		generateAll(new char[2 * A], 0,result);
		
		return result;
    }
	
	
    public static void generateAll(char[] current, int pos, ArrayList<String> result) {
        if (pos == current.length) {
            if (valid(current))
                result.add(new String(current));
        } else {
            current[pos] = '(';
            generateAll(current, pos+1, result);
            current[pos] = ')';
            generateAll(current, pos+1, result);
        }
    }

    public static boolean valid(char[] current) {
        int balance = 0;
        for (char c: current) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return (balance == 0);
    }
	
	public static void main(String[] args) {
		ArrayList<String> answer = new ArrayList<String>();
		answer = generateParenthesis(3);
		for (int i = 0; i < answer.size(); i++) {
			System.out.print(answer.get(i));
			System.out.println();
		}
	}

}
