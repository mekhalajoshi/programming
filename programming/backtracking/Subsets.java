package backtracking;

import java.util.ArrayList;
import java.util.Collections;
/**
 * Given a set of distinct integers, S, return all possible subsets.
 * 
 * Note: Elements in a subset must be in non-descending order. The solution set
 * must not contain duplicate subsets. Also, the subsets should be sorted in
 * ascending ( lexicographic ) order. The list is not necessarily sorted.
 * Example :
 * 
 * If S = [1,2,3], a solution is:
 * 
 * [ 
 * 	[], 
 *  [1], 
 *  [1, 2], 
 *  [1, 2, 3], 
 *  [1, 3], 
 *  [2], 
 *  [2, 3], 
 *  [3], 
 *  ]
 */

public class Subsets {


	/**	
	public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
	// not backtracking solution
		if(A==null)
			return null;
		
		Collections.sort(A);
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> prev = new ArrayList<ArrayList<Integer>>();
		 
		for (int i = 0; i < A.size(); i++) {
	 
			//get existing sets
			if (i == 0 || A.get(i) != A.get(i-1) || prev.size() == 0) {
				prev = new ArrayList<ArrayList<Integer>>();
				for (int j = 0; j < result.size(); j++) {
					prev.add(new ArrayList<Integer>(result.get(j)));
				}
			}
	 
			//add current number to each element of the set
			for (ArrayList<Integer> temp : prev) {
				temp.add(A.get(i));
			}
	 
			//add each single number as a set, only if current element is different with previous
			if (i == 0 || A.get(i) != A.get(i-1)) {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(A.get(i));
				prev.add(temp);
			}
	 
			//add all set created in this iteration
			for (ArrayList<Integer> temp : prev) {
				result.add(new ArrayList<Integer>(temp));
			}
		}
	 
		//add empty set
		result.add(0,new ArrayList<Integer>());
		
        Collections.sort(result, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                int an = a.size();
                int bn = b.size();
                for (int i = 0; i < Math.min(an, bn); i++) {
                    int cmp = Integer.compare(a.get(i), b.get(i));
                    if (cmp != 0)
                        return cmp;
                }
                return Integer.compare(a.size(), b.size());
            }
        });
		
		return result;
    }
	
	
	 */	
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> a = new ArrayList<Integer>();
		
		a.add(1);
		a.add(2);
		a.add(3);
		result = subsets(a);
		System.out.println("[");
		for (int i = 0; i < result.size(); i++) {
			System.out.print("[");
			for (int j = 0; j < result.get(i).size(); j++) {
				System.out.print(result.get(i).get(j)+" ");
			}
			System.out.println("]");
//			System.out.println();
		}
		System.out.println("]");
	}
	
	


// * InterviewBit Solution (backtracking)
	public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {
		ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
		output.add(new ArrayList<Integer>());
		if (a.size() == 0)
			return output;
		Collections.sort(a);
		generate(a, output, new ArrayList<Integer>(), 0);
		return output;
	}
	
	public static void generate(ArrayList<Integer> a, ArrayList<ArrayList<Integer>> output, ArrayList<Integer> temp, int index)
	{
		for (int i = index; i < a.size(); i++)
		{
			temp.add(a.get(i));
			output.add(new ArrayList<Integer>(temp));
			generate(a, output, temp, i+1);
			temp.remove(temp.size() - 1);
		}
	}
}

