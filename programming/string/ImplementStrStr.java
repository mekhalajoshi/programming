package string;

/**
 * strstr - locate a substring ( needle ) in a string ( haystack ). Try not to
 * use standard library string functions for this question.
 * 
 * Returns the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 * 
 * NOTE: Good clarification questions: What should be the return value if the
 * needle is empty? What if both haystack and needle are empty? For the purpose
 * of this problem, assume that the return value should be -1 in both cases.
 * 
 * @author mekhala
 *
 */
public class ImplementStrStr {

	public static void main(String[] args) {
		ImplementStrStr m = new ImplementStrStr();
				System.out.println(m.strStr("foobarthebarfoo", "bar"));
	}
	public int strStr(final String haystack, final String needle) {
        int n = haystack.length();
        int m = needle.length();
        for(int i=0;i<n;i++){
            int j=0;
            int k=i;
            if(haystack.charAt(k)==needle.charAt(j)){
                k++; j++;
                while(j<m && k<n && haystack.charAt(k)==needle.charAt(j)){
                    k++; j++;
                }
                if(j==m){
                    return k-j;
                }
                
            }
            
        }
        return -1;
	}
}
