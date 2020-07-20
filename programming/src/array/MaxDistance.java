package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array A of integers, find the maximum of j - i subjected to the
 * constraint of A[i] <= A[j].
 * 
 * If there is no solution possible, return -1.
 * 
 * Example :
 * 
 * A : [3 5 4 2]
 * 
 * Output : 2 for the pair (3, 4)
 * 
 *
 */
public class MaxDistance {
    // O(n^2)
    public static int maximumGap(final List<Integer> A) {
        int maxDist = -1;
        for (int i = 0; i < A.size(); i++) {
            int currentMax = -1;
            for (int j = i; j < A.size(); j++) {
                if (A.get(i) <= A.get(j)) {
                    currentMax = j - i;

                }
            }
            maxDist = Math.max(maxDist, currentMax);
        }
        return maxDist;
    }

    // more efficient solution O(n)
    public static int maximumGap2(final List<Integer> a) {
        int maxDiff;
        int i, j;
        int n = a.size();

        int[] LMin = new int[n];
        int[] RMax = new int[n];

        /*
         * Construct LMin[] such that LMin[i] stores the minimum value from (arr[0],
         * arr[1], ... arr[i])
         */
        LMin[0] = a.get(0);
        for (i = 1; i < n; ++i)
            LMin[i] = Math.min(a.get(i), LMin[i - 1]);

        /*
         * Construct RMax[] such that RMax[j] stores the maximum value from (arr[j],
         * arr[j+1], ..arr[n-1])
         */
        RMax[n - 1] = a.get(n - 1);
        for (j = n - 2; j >= 0; --j)
            RMax[j] = Math.max(a.get(j), RMax[j + 1]);

        /*
         * Traverse both arrays from left to right to find optimum j - i This process is
         * similar to merge() of MergeSort
         */
        i = 0;
        j = 0;
        maxDiff = 0;
        while (j < n && i < n) {
            if (LMin[i] <= RMax[j]) {
                maxDiff = Math.max(maxDiff, j - i);
                j = j + 1;
            } else
                i = i + 1;
        }

        return maxDiff;
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(10);
        a.add(200);
        a.add(3000);
        a.add(40000);
        a.add(10);
        System.out.println(maximumGap2(a));
    }

}
