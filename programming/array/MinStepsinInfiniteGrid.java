package array;

import java.util.ArrayList;

/***
 * You are in an infinite 2D grid where you can move in any of the 8 directions
 * :
 * 
 * (x,y) to (x+1, y), (x - 1, y), (x, y+1), (x, y-1), (x-1, y-1), (x+1,y+1),
 * (x-1,y+1), (x+1,y-1) You are given a sequence of points and the order in
 * which you need to cover the points. Give the minimum number of steps in which
 * you can achieve it. You start from the first point.
 * 
 * Example :
 * 
 * Input : [(0, 0), (1, 1), (1, 2)] Output : 2 It takes 1 step to move from (0,
 * 0) to (1, 1). It takes one more step to move from (1, 1) to (1, 2).
 * 
 * This question is intentionally left slightly vague. Clarify the question by
 * trying out a few cases in the “See Expected Output” section.
 *
 */

public class MinStepsinInfiniteGrid {

	public static int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
		int  result=0;
		for(int i = 1; i < A.size(); i++){
			result += Math.max( Math.abs(A.get(i) - A.get(i-1)), Math.abs(B.get(i) - B.get(i-1)) );
        }
		return result;
	}

	public static void main(String[] args) {
		int [] arr1= {0,1,2};
		ArrayList<Integer> A = new ArrayList<Integer> ();
		for(int i:arr1) {
			A.add(i);
		}
		
		int [] arr2= {0,1,3};
		ArrayList<Integer> B = new ArrayList<Integer> ();
		for(int i:arr2) {
			B.add(i);
		}
		
		System.out.println(coverPoints(A,B));
	}

}
