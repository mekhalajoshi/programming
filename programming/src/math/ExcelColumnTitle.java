package math;

/**
 * Given a positive integer, return its corresponding column title as appear in
 * an Excel sheet.
 * 
 * For example:
 * 
 * 1 -> A 2 -> B 3 -> C ... 26 -> Z 27 -> AA 28 -> AB
 * 
 *
 *
 * Input Output 
 * 	26 		Z 
 * 	51 		AY 
 * 	52 		AZ 
 * 	80 		CB 
 * 	676 		YZ 
 * 	702 		ZZ 
 * 	705 		AAC
 *
 */
public class ExcelColumnTitle {
	
	public static String convertToTitle(int a) {
		StringBuilder sb = new StringBuilder();
		 
	    while (a > 0)
        {
            // Find remainder
            int rem = a % 26;
 
            // If remainder is 0, then a 
            // 'Z' must be there in output
            if (rem == 0)
            {
                sb.append("Z");
                a = (a / 26) - 1;
            }
            else // If remainder is non-zero
            {
                sb.append((char)((rem - 1) + 'A'));
                a = a / 26;
            }
        }
	    return sb.reverse().toString();
	   
	}
	
	public static void main(String[] args) {
		System.out.println(convertToTitle(705));
	}
}
