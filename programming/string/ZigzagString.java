package string;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this: (you may want to display this pattern in a fixed font for
 * better legibility)
 * 
 * P.......A........H.......N 
 * ..A..P....L....S....I...I....G
 * ....Y.........I........R
 * 
 * And then read line by line: PAHNAPLSIIGYIR
 * 
 * Write the code that will take a string and make this conversion given a
 * number of rows:
 * 
 * string convert(string text, int nRows); convert("PAYPALISHIRING", 3) should
 * return "PAHNAPLSIIGYIR" Example 2 : ** ABCD, 2 can be written as
 * 
 * A....C ...B....D and hence the answer would be ACBD.
 * 
 * Input: str = "GEEKSFORGEEKS" 
 * n = 3 
 * Output: GSGSEKFREKEOE
 *
 */
public class ZigzagString {

	
	public int getCount(int direction, int i, int b) {
		if (direction == 0) {
			return (b - i - 1) * 2;
		} else {
			return (i) * 2;
		}
	}

	public String convert(String a, int b) {
		StringBuilder result = new StringBuilder();
		int direction = 0; // 0==down; 1==up;
		int current = 0;
		if (b == 1)
			return a;
		for (int i = 0; i < b; i++) {
			current = i;
			direction = 0;
			if (i == b - 1)
				direction = 1;
			while (current < a.length()) {
				result.append(a.charAt(current));

				current += getCount(direction, i, b);
				if (i == 0) {
					direction = 0;
				} else if (i == b - 1) {
					direction = 1;
				} else {
					if (direction == 1) {
						direction = 0;
					} else
						direction = 1;
				}
			}
		}
		return result.toString();
	}

	public String convert2(String a, int b) {
		StringBuilder[] result = new StringBuilder[b];
		 for (int i = 0; i < b; i++) {
		        result[i] = new StringBuilder();
		    }
		int direction = 0;
		int i = 0;
		int level = 0;
		while (i < a.length()) {
			switch (direction) {
			case 0:result[level] = result[level].append(a.charAt(i));
				   if(level==b-1){
					   direction=1;
					   level--;
				   }else {
					   level++;
				   }
				   i++;
				   break;
			case 1:result[level] = result[level].append(a.charAt(i));
				   if(level==0) {
					   direction=0;
					   level++;
				   }else {
					   level--;
				   }
				   i++;
				   break;
			}
		}
		StringBuilder answer = new StringBuilder();
		for(StringBuilder s:result) {
			answer =answer.append(s);
		}
		return answer.toString();
	}
	
    //InterviewBit Solution
	public String convert3(String a, int b) {
	    if (b == 1) return a;
	    b--; // make level 0-based
	    
	    StringBuilder[] rows = new StringBuilder[b + 1];
	    for (int i = 0; i <= b; i++) {
	        rows[i] = new StringBuilder();
	    }
	    
	    boolean naturalOrder = true;
	    int level = 0;
	    for (int i = 0; i < a.length(); i++) {
	        rows[level].append(a.charAt(i));
	        
	        if (naturalOrder) {
	            level++;
	        } else {
	            level--;
	        }
	        
	        if (level > b) {
	            naturalOrder = false;
	            level = b - 1;
	        } else if (level < 0) {
	            naturalOrder = true;
	            level = 1;
	        }
	    }
	    
	    StringBuilder result = new StringBuilder();
	    for (StringBuilder row : rows) {
	        result.append(row);
	    }
	    return result.toString();
	}
	
	public static void main(String[] args) {
		ZigzagString m = new ZigzagString();
		System.out.println(m.convert("GEEKSFORGEEKS", 3));
		System.out.println(m.convert2("GEEKSFORGEEKS", 3));
		System.out.println(m.convert3("GEEKSFORGEEKS", 3));
	}
}
