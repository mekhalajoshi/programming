package array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *Given a read only array of n + 1 integers between 1 and n, find one number that repeats 
 *in linear time using less than O(n) space and traversing the stream sequentially O(1) times.

Sample Input:

[3 4 1 4 1]
Sample Output:

1
If there are multiple possible answers ( like in the sample case above ), output any one.

If there is no duplicate, output -1 
 *
 *
 *
 *Notes:
 *array of n + 1 integers between 1 and n == atleast one number duplicate number
 *O(n) space == can copy all elements into another data structure (set in this case)
 */



public class FindDuplicateInArray {
	//Function returns the FIRST duplicate element
	public static int repeatedNumber(final List<Integer> a) {
	    Set<Integer> set = new HashSet<Integer>();
	    if(a ==null ||a.isEmpty()){
	        return -1;
	    }
	    for(int i =0;i<a.size();i++){
	        int elem = a.get(i);
	        if(set.contains(elem)){
	            return elem;
	        }else{
	            set.add(elem);
	        }
	    }
	    
	    return -1;
	}
	

	
	//function returns the SMALLEST duplicate element
	public static int repeatedNumber2(final List<Integer> a) {
	    Set<Integer> set = new HashSet<Integer>();
	    if(a ==null ||a.isEmpty()){
	        return -1;
	    }
	    int dup =Integer.MAX_VALUE;
	    boolean flag = false;
	    for(int i =0;i<a.size();i++){
	        int elem = a.get(i);
	        if(set.contains(elem)){
	            flag = true;
	            if(elem<dup){
	                dup = elem;
	            }
	        }else{
	            set.add(elem);
	        }
	    }
	    if(flag == false){
	        return -1;
	    }
	    return dup;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		a.add(3);
//		a.add(3);
//		a.add(3);
//		a.add(4);
//		a.add(1);
//		a.add(5);
//		a.add(3);
//		a.add(7);
		for (int i : a) {
			System.out.print(i);
		}
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println(repeatedNumber(a));
		System.out.println(repeatedNumber2(a));
	}

}
