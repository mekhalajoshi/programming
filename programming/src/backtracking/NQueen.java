package backtracking;

import java.util.ArrayList;

/**
 * 
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard
 * such that no two queens attack each other. Given an integer n, return all
 * distinct solutions to the n-queens puzzle. Each solution contains a distinct
 * board configuration of the n-queens’ placement, where 'Q' and '.' both
 * indicate a queen and an empty space respectively.
 * 
 * For example, There exist two distinct solutions to the 4-queens puzzle:
 * 
 * [ [".Q..", // Solution 1 "...Q", "Q...", "..Q."],
 * 
 * ["..Q.", // Solution 2 "Q...", "...Q", ".Q.."] ]
 * 
 * Unfortunately, there is no magic trick to solving this problem. This is more
 * of a bruteforce problem. A more intelligent bruteforce.
 * 
 * Notes : 1) There can exactly be one queen per row. Otherwise the 2 queens in
 * the row would collide. If you miss out on a row, there cannot be N queens on
 * the board. 2)Every column needs to have exactly one queen. 3) The left
 * diagonal cannot have more than one queen ( Unique (row + col) ) 4) The right
 * diagonal cannot have more thna one queen ( Unique (row - col) ) We can start
 * placing a queen per row. When placing a queen on a row, col, we need to check
 * if the position is available based on what we have already placed. Then we
 * move to the next row.
 *
 */
public class NQueen {

	public static void main(String[] args) {
		ArrayList<ArrayList<String>> answer = new ArrayList<ArrayList<String>>();
		int n = 4;
		answer = solveNQueens(n);
		if (answer != null) {
			for (int i = 0; i < answer.size(); i++) {
				System.out.print(answer.get(i));
			}
		}
	}

	public static ArrayList<ArrayList<String>> solveNQueens(int N) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		ArrayList<ArrayList<String>> answer = new ArrayList<ArrayList<String>>();
		for (int i = 0; i < N; i++) {
			result.add(new ArrayList<String>());
			for (int j = 0; j < N; j++) {
				result.get(i).add(".");
			}
		}
		solve(result, answer, N, 0);
		return answer;

	}

	private static boolean solve(ArrayList<ArrayList<String>> result, ArrayList<ArrayList<String>> answer, int N,
			int col) {
		if (col == N) {

			addToAnswer(result, answer, N);
			return true;
		}
		for (int i = 0; i < N; i++) {

			if (isSafe(result, col, i, N)) {
				// place queen
				result.get(i).set(col, "Q");

				// solve for next column
				// print all solutions
				solve(result, answer, N, col + 1);

				// print first solution
				// if(solve(result,answer,N,col+1)==true) {
				// return true;
				// }

				// backtrack if no result found
				result.get(i).set(col, ".");
			}
		}
		return false;
	}

	private static void addToAnswer(ArrayList<ArrayList<String>> result, ArrayList<ArrayList<String>> answer, int N) {
		ArrayList<String> temp = new ArrayList<String>();
		for (int i = 0; i < N; i++) {
			String s = "";
			for (int j = 0; j < N; j++) {
				String str = (result.get(i).get(j));
				s = s.concat(str);
			}
			temp.add(s);
		}

		answer.add(temp);
	}

	private static boolean isSafe(ArrayList<ArrayList<String>> result, int col, int row, int N) {
		// check horizontal left
		for (int i = 0; i <= col; i++) {
			if (result.get(row).get(i) == "Q")
				return false;
		}

		// check vertical up
		for (int i = 0; i <= row; i++) {
			if (result.get(i).get(col) == "Q")
				return false;
		}

		// check diagonal left down
		for (int i = row, j = col; j >= 0 && i < N; i++, j--) {
			if (result.get(i).get(j) == "Q") {
				return false;
			}
		}

		// check diagonal left up
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (result.get(i).get(j) == "Q") {
				return false;
			}
		}

		return true;
	}
}
