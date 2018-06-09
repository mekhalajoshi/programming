package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * Example :
 * 
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * 
 * Rain water trapped: Example 1
 * 
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In
 * this case, 6 units of rain water (blue section) are being trapped.
 * 
 * https://www.interviewbit.com/problems/rain-water-trapped/
 * 
 */
public class RainWaterTrapped {
	public static int trap(final List<Integer> a) {
		int sum = 0;
		int [] left = new int[a.size()];
		int [] right = new int[a.size()];
		
		// left[i] contains height of tallest bar to the
	    	// left of i'th bar including itself
		left[0] = a.get(0);
		for(int i=1;i<a.size();i++) {
			left[i]= Math.max(left[i-1], a.get(i));
		}
		
		// Right [i] contains height of tallest bar to
	    	// the right of ith bar including itself
		right[a.size()-1] = a.get(a.size()-1);
		for(int i=a.size()-2 ; i>=0; i--) {
			right[i] = Math.max(right[i+1], a.get(i));
		}
		
		// Calculate the accumulated water element by element
	    	// consider the amount of water on i'th bar, the
	    	// amount of water accumulated on this particular
	    	// bar will be equal to min(left[i], right[i]) - arr[i] .
		for(int i =0; i<a.size(); i++) {
			sum += Math.min(left[i], right[i]) - a.get(i);
		}
			return sum;
	}

	public static void main(String[] args) {
		List<Integer> a = new ArrayList<Integer>();
		a.add(0);
		a.add(1);
		a.add(0);
		a.add(2);
		a.add(1);
		a.add(0);
		a.add(1);
		a.add(3);
		a.add(4);
		a.add(1);
		a.add(2);
		a.add(1);
		
		System.out.println(trap(a));
		
	}
}
