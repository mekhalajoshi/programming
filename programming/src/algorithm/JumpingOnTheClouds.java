


package algorithm;


import java.util.Stack;

/**
 * Emma is playing a new mobile game that starts with consecutively numbered clouds.
 *  Some of the clouds are thunderheads and others are cumulus. 
 *  She can jump on any cumulus cloud having a number that is equal to the number of
 *   the current cloud plus  1 or 2 . She must avoid the thunderheads. 
 *   Determine the minimum number of jumps it will take Emma to jump 
 *   from her starting postion to the last cloud. 
 *   It is always possible to win the game.
 *   For each game, Emma will get an array of clouds numbered 0 if they are safe 
 *   or 1 if they must be avoided. 
 *   For example,c=[0,1,0,0,0,1,0]  
 *   The number on each cloud is its index in the list so she must avoid the clouds 
 *   at indexes 1 and 5. 
 *   She could follow the following two paths: 0->2->4->6 or 0->2->3->4->6 . 
 *   The first path takes 3 jumps while the second takes 4.
 *   Answer = 3
 *   
 *   input:
 *   7
 *   0 0 1 0 0 1 0'
 *   output
 *   4
 *   
 *   input:
 *   6
 *   0 0 0 0 1 0
 *   output
 *   3
 */
public class JumpingOnTheClouds {
	// Solution 1
	static int jumpingOnClouds(int[] c) {
		Stack<Integer> s = new Stack<Integer>();
		int count = 0;
		for (int i = 0; i < c.length; i++) {
			if (c[i] == 0) {
				s.push(0);
			} else {
				count = count+(s.size()/2)+1;
				s.clear();
			}
		}
        return (int) (s.isEmpty() ?  count :  count+Math.ceil(s.size()/2));
	}
	
	// Solution 2
	static int jumpingOnClouds2(int[] c) {
		int count=0;
		for(int i=0; i < c.length-1; i=i+0){
            if(i+2<c.length && c[i+2]==0) 
            	i+=2;
            else          
            	i+=1;
            count++;
        }
		return count;
	}

	public static void main(String[] args) {
		int[] c = { 0, 0, 1, 0, 0, 1, 0};

		System.out.println(jumpingOnClouds(c));
		System.out.println(jumpingOnClouds2(c));

	}
}
