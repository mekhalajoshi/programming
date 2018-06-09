package hashing;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * 
 * For Given Number N find if its COLORFUL number or not
 * 
 * Return 0/1
 * 
 * COLORFUL number:
 * 
 * A number can be broken into different contiguous sub-subsequence parts.
 * Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324
 * 245. And this number is a COLORFUL number, since product of every digit of a
 * contiguous subsequence is different Example:
 * 
 * N = 23 2 3 23 2 -> 2 3 -> 3 23 -> 6 this number is a COLORFUL number since
 * product of every digit of a sub-sequence are different.
 * 
 * Output : 1
 * 
 *
 */
public class ColorfulNumber {

	public static void main(String[] args) {
		System.out.println(colorful(3245));
	}
	public static int colorful(int a) {
	ArrayList<Integer> list = new ArrayList<Integer>();
	HashSet<Integer> set = new HashSet<Integer>();
	while(a>0) {
		int remainder = a%10;
		list.add(remainder);
		a=a/10;
	}
	 int i = 0;
        while(i < list.size()){
            
            int j = i + 1;
            if(set.contains(list.get(i)))
                return 0;
            set.add(list.get(i));
            int result = list.get(i);
            while(j < list.size() && i != list.size() - 1){
                result = result * list.get(j);
                if(set.contains(result))
                    return 0;
                set.add(result);
                j++;
            }
            i++;                    
        }
        return 1;
}
}
