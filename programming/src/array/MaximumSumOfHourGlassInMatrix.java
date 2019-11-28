package array;
/**
 * You are given a 6*6 2D array. An hourglass in an array is a portion shaped like this:
a b c
  d
e f g
For example, if we create an hourglass using the number 1 within an array full of zeros, it may look like this:
1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
Actually there are many hourglasses in the array above. The three leftmost hourglasses are the following:
1 1 1     1 1 0     1 0 0
  1         0         0
1 1 1     1 1 0     1 0 0
The sum of an hourglass is the sum of all the numbers within it. The sum for the hourglasses above are 7, 4, and 2, respectively.
In this problem you have to print the largest sum among all the hourglasses in the array.
Note: If you have already solved the problem Java 2D array in the data structures chapter in the Java domain, you may skip this challenge.
Input Format
There will be exactly 6 lines, each containing 6 integers seperated by spaces. Each integer will be between -9 and 9 inclusive.
Output Format
Print the answer to this problem on a single line.
Sample Input
1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 2 4 4 0
0 0 0 2 0 0
0 0 1 2 4 0
Sample Output
19
Explanation
The hourglass which has the largest sum is:
2 4 4
  2
1 2 4
 *
 *
 */
public class MaximumSumOfHourGlassInMatrix {

	static int hourglassSum(int[][] arr) {
		int maxSum=Integer.MIN_VALUE;
		int n=arr.length;
		int m= arr[0].length;
		for(int i=0;i<=n-3;i++) {
			for(int j=0;j<=m-3;j++) {
				int currentMax= arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i+1][j+1]+arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2];
				maxSum= Math.max(maxSum, currentMax);
			}
		}
		return maxSum;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int [][] arr={{1, 1, 1, 0, 0, 0,}, 
    	  			{0, 1, 0, 0, 0, 0}, 
    	  			{1, 1, 1, 0 ,0, 0},
    	  			{0, 0, 2, 4, 4, 0},
    	  			{0, 0, 0, 2, 0, 0},
    	  			{0, 0, 1, 2, 4, 0},
    	  			};
      int [][] arr2= {
    		  {-9, -9, -9,  1, 1, 1 },
    		  {0, -9,  0,  4, 3, 2},
    		 {-9, -9, -9,  1, 2, 3},
    		  {0,  0,  8,  6, 6, 0},
    		  {0,  0,  0, -2, 0, 0},
    		  {0,  0,  1,  2, 4, 0}
      };
      
      int [][] arr3= {
    		  {-1, -1, 0,  -9, -2, -2 },
    		  {-2, -1 ,-6, -8 ,-2, -5},
    		 {-1, -1, -1, -2, -3, -4},
    		  {-1, -9, -2, -4, -4, -5},
    		  {-7, -3 ,-3, -2, -9, -9},
    		  {-1, -3, -1, -2 ,-4 ,-5}
      };
      
		System.out.println(hourglassSum(arr));
		System.out.println(hourglassSum(arr2));
		System.out.println(hourglassSum(arr3));

      }
}