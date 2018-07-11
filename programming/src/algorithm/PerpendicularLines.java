package algorithm;

/***
 * Given 4 points of the form (xi, yi) in 2D plane, find out if the lines formed by (x1, y1), (x2, y2) and (x3, y3), (x4, y4) are perpendicular to each other.

NOTE:

It is NOT provided that the points are distinct i.e the first two or the last two points may be equal too!
INPUT FORMAT:

First line T is the number of test cases. Each test case is followed by 2 lines.

The first line of every test case contains four integers (x1, y1) and (x2, y2).

The second line contains four integers (x3, y3) and (x4, y4).

OUTPUT FORMAT:

For every test case :

print "YES" without quotes if the lines are perpendicular to each other
print "NO" without quotes if the lines are not perpendicular
print "INVALID" without quotes if there are less than 2 lines
CONSTRAINTS:

1 <= T <= 10^5

-10^18 <= xi <= 10^18

-10^18 <= yi <= 10^18
 */

/***
 * PRE REQUISITES :

Euclids GCD Algorithm
If a line passes through (a, b) and (c, d) then its slope = (d - b) / (c - a)
If product of slopes of two lines = -1, then they are perpendicular, else not
In every test case, the first 4 points would form a line of slope m1 (Let us say) and the next 4 points would form another line of slope m2. If both the points in any of the 2 lines are same, the line cannot be formed and hence the answer would be "INVALID"

If both points are valid, we may obtain their slopes and manipulate them to get the answer. If the slopes are not taken in double format and instead taken separately as numerators and denominators, the to obtain the simplest fraction, we will require the GCD Algorithm.

However, an exception has to be added whenever one of the lines is parallel to y-axis as their slope would be infinity!

Complexity : log(xi) OR log(yi) per query --> qlog(xi) OR qlog(yi)


 * 
 */
/**
 * 
 * INPUT
4
1 2 3 3 
3 3 1 7
3 4 8 9
13 5 13 5
5 7 12 9
1 5 9 15
7 9 10 12
10 14 17 21
 */
/*
 * OUTPUT
YES
INVALID
NO
NO

 */
		
import java.util.*;

public class PerpendicularLines {
	static long gcd(long a, long b) {
		if (b == 0) {
			return a;
		} else {
			return gcd(b, a % b);
		}
	}

	
	public static void main(String args[]) throws Exception {

		// Write your code here

		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int z = 0; z < testCases; z++) {
			int x1 = in.nextInt();
			int y1 = in.nextInt();
			int x2 = in.nextInt();
			int y2 = in.nextInt();

			int x3 = in.nextInt();
			int y3 = in.nextInt();
			int x4 = in.nextInt();
			int y4 = in.nextInt();

			// System.out.println("x1 "+x1);
			// System.out.println("y1 "+y1);
			// System.out.println("x2 "+x2);
			// System.out.println("y2 "+y2);
			// System.out.println("x3 "+x3);
			// System.out.println("y3 "+y3);
			// System.out.println("x4 "+x4);
			// System.out.println("y4 "+y4);

			long m1num, m2num, m1den, m2den;

			if (x1 == x2 && y1 == y2) { // PARALLEL WHEN (x1 y1) = (x2 y2) OR (x3 y3) = (x4 y4)
				System.out.println("INVALID");
			} else if (x3 == x4 && y3 == y4) {
				System.out.println("INVALID");
			} else {
				m1num = y2 - y1;
				m1den = x2 - x1; // CALCULATING NUMERATOR AND DENOMINATOR FOR BOTH SLOPES m1 AND m2
				m2num = y4 - y3;
				m2den = x4 - x3;
				if (m1den == 0 && m2den == 0) { // BOTH LINES PARALLEL TO Y AXIS
					System.out.println("NO");
				} else if (m1den == 0) { // ONE OF THE LINES IS PARALLEL TO Y AXIS
					if (m2num == 0) {
						System.out.println("YES");
					} else {
						System.out.println("NO");
					}
				} else if (m2den == 0) {
					if (m1num == 0) {
						System.out.println("YES");

					} else {
						System.out.println("NO");
					}
				} else { // GENERAL CASE - CALCULATE BOTH FRACTIONS AND COMPARE
					int neg = 0;
					if (m1num < 0) {
						neg++;
					}
					if (m2num < 0) {
						neg++;
					}
					if (m1den < 0) {
						neg++;
					}
					if (m2den < 0) {
						neg++;
					}

					long p = gcd(Math.abs(m1num), Math.abs(m1den));
					long q = gcd(Math.abs(m2num), Math.abs(m2den));
					m1num /= p;
					m1den /= p;
					m2num /= q;
					m2den /= q;

					if (Math.abs(m1num) == Math.abs(m2den) && Math.abs(m2num) == Math.abs(m1den) && neg % 2 == 1) {
						System.out.println("YES");
					} else {
						System.out.println("NO");
					}
				}

			}

		}
		in.close();
	}
}
