package string;

/**
 * Given an input string, reverse the string word by word.
 * 
 * Example:
 * 
 * Given s = "the sky is blue",
 * 
 * return "blue is sky the".
 * 
 * A sequence of non-space characters constitutes a word. Your reversed string
 * should not contain leading or trailing spaces, even if it is present in the
 * input string. If there are multiple spaces between words, reduce them to a
 * single space in the reversed string.
 * 
 * @author MJ
 *
 */
public class ReverseTheString {

	public static void main(String[] args) {
		System.out.println(reverseWords("the sky is blue"));
	}

	public static String reverseWords(String s) {
		if (s.length() == 1)
			return s;
		if (s.charAt(0) == ' ')
			s = s.replaceFirst("\\s+", "");
		String str = stringreverse(s);
		String reverse = "";

		if (str.charAt(0) == ' ') {
			str = str.replaceFirst("\\s+", "");
		}
		String[] arr = str.split("\\s+");

		for (int i = 0; i < arr.length; i++) {
			if (i == arr.length - 1) {
				reverse = reverse + stringreverse(arr[i]);

			} else
				reverse = reverse + stringreverse(arr[i]) + " ";

		}

		return reverse;
	}

	public static String stringreverse(String s) {
		if (s == null) {
			return null;
		}
		char[] str = s.toCharArray();
		int i = 0;
		int j = str.length - 1;
		while (i != (str.length) / 2) {
			char temp;
			temp = str[i];
			str[i] = str[j];
			str[j] = temp;
			i++;
			j--;
		}
		return String.valueOf(str);
	}
}
