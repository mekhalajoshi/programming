package matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given a matrix of m * n elements (m rows, n columns), return all elements of
 * the matrix in spiral order.
 * 
 * Example:
 * 
 * Given the following matrix:
 * 
 * [ 
 * [ 1, 2, 3 ], 
 * [ 4, 5, 6 ], 
 * [ 7, 8, 9 ] 
 * s] You should return
 * 
 * [1, 2, 3, 6, 9, 8, 7, 4, 5] Problem Approach :
 * 
 * Complete solution in the hints.
 * 
 * https://youtu.be/siKFOI8PNKM
 *
 */
public class SpiralOrderMatrixI {



	public static ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		// Populate result;
		int m, n;

		m = A.size();
		n = A.get(0).size();

		if (m == 0)
			return result;

//		int len;
		int dir = 0; // right
		int row, col, layer;
		row = col = layer = 0;

		result.add(A.get(0).get(0));

		for (int step = 1; step < m * n; step++) {

			switch (dir) {

			// Go right
			case 0:

				if (col == n - layer - 1) {
					dir = 1;
					row++;
				} else {
					col++;
				}

				break;

			// Go down
			case 1:

				if (row == m - layer - 1) {
					dir = 2;
					col--;
				} else {
					row++;
				}

				break;

			// Go left
			case 2:

				if (col == layer) {
					dir = 3;
					row--;
				} else {
					col--;
				}

				break;

			// Go up
			case 3:

				if (row == layer + 1) {
					dir = 0;
					col++;
					layer++;
				} else {
					row--;
				}

				break;
			}
			// System.out.println(row + " " + col);
			result.add(A.get(row).get(col));

		}
		return result;
	}
	
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> A1 = new ArrayList<Integer>();
		ArrayList<Integer> A2 = new ArrayList<Integer>();
		ArrayList<Integer> A3 = new ArrayList<Integer>();
//		ArrayList<Integer> A4 = new ArrayList<Integer>();
		
		A1.add(1);
		A1.add(2);
		A1.add(3);
		A2.add(4);
		A2.add(5);
		A2.add(6);
		A3.add(7);
		A3.add(8);
		A3.add(9);
		A.add(A1);
		A.add(A2);
		A.add(A3);
//		A.add(A4);
		
		System.out.println(spiralOrder(A));
		
	}
}
