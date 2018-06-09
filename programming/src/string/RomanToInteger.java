package string;

/**
 * 
 * Given a roman numeral, convert it to an integer.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * Read more details about roman numerals at Roman Numeric System(wiki)
 * 
 * Example :
 * 
 * Input : "XIV" Return : 14 Input : "XX" Output : 20
 * 
 * 
 *
 */
public class RomanToInteger {

	public int romanToInt(String a) {
		if (a == null)
			return -1;
		int sum = 0;
		int current = 0;
		int prev = -1;
		for (int i = a.length() - 1; i >= 0; i--) {
			current = getIntValue(a.charAt(i));
			if (current < prev) {
				sum -= current;
			} else {
				sum += current;
			}
			prev = current;
		}
		return sum;
	}

	public int getIntValue(char a) {
		if (a == 'M')
			return 1000;
		if (a == 'D')
			return 500;
		if (a == 'C')
			return 100;
		if (a == 'L')
			return 50;
		if (a == 'X')
			return 10;
		if (a == 'V')
			return 5;
		if (a == 'I')
			return 1;
		return 0;
	}

	// InterviewBit Solution
	public static int romanToInt2(String a) {

		String str = "IVXLCDM";
		int num[] = { 1, 5, 10, 50, 100, 500, 1000 };
		char ch, ch1;
		int sum = 0, sub = 0, i;
		for (i = 0; i < a.length() - 1; i++) {
			ch = a.charAt(i);
			ch1 = a.charAt(i + 1);
			if (str.indexOf(ch1) <= str.indexOf(ch)) {
				sum = sum + num[str.indexOf(ch)];
				sum = sum - sub;
				sub = 0;
			} else {
				sub = sub + num[str.indexOf(ch)];
			}
		}
		sum = sum + num[str.indexOf(a.charAt(i))];
		sum = sum - sub;
		return sum;

	}

	public static void main(String[] args) {
		RomanToInteger m = new RomanToInteger();
		System.out.println(m.romanToInt("XIV")); // 14
		System.out.println(m.romanToInt("MDCCLXXVI"));// 1776
		System.out.println(m.romanToInt("MCMLIV"));// 1954
		System.out.println(m.romanToInt("CCXLVI"));// 246
	}

}
