package binarySearch;

/**
 * Implement int sqrt(int x).
 * 
 * Compute and return the square root of x.
 * 
 * If x is not a perfect square, return floor(sqrt(x))
 * 
 * Example :
 * 
 * Input : 11 Output : 3
 *
 */
public class SquareRootOfInteger {

	//InterviewBit solution
	public int sqrt2(int A) {

		int low, high, root;
		int mid;

		low = 1;
		high = A;
		root = 0;

		while (low <= high) {

			mid = (low + high) / 2;

			if (mid == A / mid && (A % mid == 0))
				return mid;

			if (mid <= A / mid) {
				root = mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}

		}

		return root;

	}

	public static int sqrt(int x) {

		// Base cases
		if (x == 0 || x == 1)
			return x;

		// Do Binary Search for floor(sqrt(x))
		int start = 1, end = x, ans = -1;
		while (start <= end) {
			int mid = (start + end) / 2;

			// If x is a perfect square
			if (mid == x / mid)
				return mid;

			// Since we need floor, we update answer when mid*mid is
			// smaller than x, and move closer to sqrt(x)

			if (mid < x / mid) {
				start = mid + 1;
				ans = mid;
			} else // If mid*mid is greater than x
				end = mid - 1;
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(sqrt(4));
	}

}
