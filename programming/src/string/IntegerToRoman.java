package string;

import java.util.HashMap;

/**
 * 
 * Given an integer, convert it to a roman numeral, and return a string
 * corresponding to its roman numeral version
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * Example :
 * 
 * Input : 5 Return : "V"
 * 
 * Input : 14 Return : "XIV" Note : This question has a lot of scope of
 * clarification from the interviewer. Please take a moment to think of all the
 * needed clarifications and see the expected response using “See Expected
 * Output” For the purpose of this question,
 * https://projecteuler.net/about=roman_numerals has very detailed explanations.
 * 
 * Symbol 	I 	V 	X 	L 	C 	  D 		M 
 * Value 	1 	5 	10 	50 	100   500 	1,000
 *
 */
public class IntegerToRoman {

	public String intToRoman2(int A) {
        StringBuilder result = new StringBuilder();
        while(A>0){
            if(A>=1000){
                result.append("M");
                A-=1000;
            }
            else if(A>=900){
                result.append("CM");
                A-=900;
            }
            else if(A>=500){
                result.append("D");
                A-=500;
            }
            else if(A>=400){
                result.append("CD");
                A-=400;
            }
            else if(A>=100){
                result.append("C");
                A-=100;
            }
            else if(A>=90){
                result.append("XC");
                A-=90;
            }
            else if(A>=50){
                result.append("L");
                A-=50;
            }
            else if(A>=40){
                result.append("XL");
                A-=40;
            }
            else if(A>=10){
                result.append("X");
                A-=10;
            }
            else if(A==9){
                result.append("IX");
                A-=9;
            }
            else if(A>=5){
                result.append("V");
                A-=5;
            }
            else if(A==4){
                result.append("IV");
                A-=4;
            }
            else if(A>=1){
                result.append("I");
                A-=1;
            }
        }
        return result.toString();
    }
	
	public String intToRoman(int num) {
		int[] bases = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		String result = new String();
		map.put(1, "I");
		map.put(4, "IV");
		map.put(5, "V");
		map.put(9, "IX");
		map.put(10, "X");
		map.put(40, "XL");
		map.put(50, "L");
		map.put(90, "XC");
		map.put(100, "C");
		map.put(400, "CD");
		map.put(500, "D");
		map.put(900, "CM");
		map.put(1000, "M");
		for (int i : bases) {
			while (num >= i) {
				result += map.get(i);
				num -= i;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		IntegerToRoman m = new IntegerToRoman();
		System.out.println(m.intToRoman(5));
	}
}
