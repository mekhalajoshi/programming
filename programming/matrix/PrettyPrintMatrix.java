package matrix;

import java.util.ArrayList;

/**
 * Print concentric rectangular pattern in a 2d matrix. Let us show you some
 * examples to clarify what we mean.
 * 
 * Example 1:
 * 
 * Input: A = 4. Output:
 * 
 * 4 4 4 4 4 4 4 
 * 4 3 3 3 3 3 4 
 * 4 3 2 2 2 3 4 
 * 4 3 2 1 2 3 4 
 * 4 3 2 2 2 3 4 
 * 4 3 3 3 3 3 4 
 * 4 4 4 4 4 4 4 
 * 
 * Example 2:
 * 
 * Input: A = 3. Output:
 * 
 * 3 3 3 3 3 
 * 3 2 2 2 3 
 * 3 2 1 2 3 
 * 3 2 2 2 3 
 * 3 3 3 3 3 
 * 
 * The outermost rectangle is
 * formed by A, then the next outermost is formed by A-1 and so on.
 * 
 * You will be given A as an argument to the function you need to implement, and
 * you need to return a 2D array.
 */

public class PrettyPrintMatrix {

	public ArrayList<ArrayList<Integer>> prettyPrint(int a) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		int start = 0;
		int stop = (a * 2) - 2;
		int level = a;
		for (int i = 0; i < (a * 2) - 1; i++) {
			result.add(new ArrayList<Integer>());
			for (int j = 0; j < (a * 2) - 1; j++) {
				result.get(i).add(0);
			}
		}
		while (level >= 1) {
			printLevel(level, result, start, stop);
			level--;
			start++;
			stop--;
		}
		return result;
	}

	private void printLevel(int level, ArrayList<ArrayList<Integer>> result, int start, int stop) {
		for (int i = start; i <= stop; i++) {
			result.get(start).set(i, level);

			result.get(stop).set(i, level);

			result.get(i).set(stop, level);

			result.get(i).set(start, level);

		}
	}

	public  ArrayList<ArrayList<Integer>> prettyPrint2(int a) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		int len = (a*2) - 1;
		int length = len;
		int [][] arr = new int[len][len];
		int index = 0;
		while(a>0) {
			
			//top
			for(int i=index;i<len;i++) {
				arr[index][i]=a;
				
			}
			
			//right
			for(int i =index+1; i<len;i++) {
				arr[i][len-1] = a;
			}
			
			//bottom
			for(int i=index;i<len;i++) {
				arr[len-1][i]=a;
			}
			
			//left
			for(int i=index;i<len-1;i++) {
				arr[i][index]=a;
			}
			
			index++;
			len -=1;
			a--;
		}
//		System.out.println();
		for(int i=0;i<length; i++) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for(int j = 0;j<length;j++) {
				temp.add(arr[i][j]);
//				System.out.print(arr[i][j]+" ");
			}
			result.add(temp);
//			System.out.println();
		}
		return result;
	}

	private void printMatrix(ArrayList<ArrayList<Integer>> result) {
		for (int i = 0; i < result.size(); i++) {
			System.out.print("[");
			for (int j = 0; j < result.get(i).size(); j++) {
				System.out.print(result.get(i).get(j) + " ");
			}
			System.out.println("]");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		PrettyPrintMatrix s = new PrettyPrintMatrix();
		result = s.prettyPrint(4);
		s.printMatrix(result);
		result = s.prettyPrint2(5);
		s.printMatrix(result);

	}

}
