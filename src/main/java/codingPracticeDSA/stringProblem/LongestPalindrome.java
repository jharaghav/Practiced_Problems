package codingPracticeDSA.stringProblem;
//https://leetcode.com/problems/longest-palindromic-substring/
public class LongestPalindrome {
    int resultStart;
    int resultLength;
    public static void main(String... s){
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome("babad"));
    }
    public String longestPalindrome(String s) {
        int strLength = s.length();
        if(strLength < 2) return s;

        for(int start = 0;start<strLength;start++){
            checkMaxPalindrome(s, start, start); //this is for odd length
            checkMaxPalindrome(s, start, start+1); // this is for even length
        }
        return s.substring(resultStart, resultStart + resultLength);
    }

    public void checkMaxPalindrome(String s, int begin,int end){
        while(begin >= 0 && end < s.length() && s.charAt(begin) == s.charAt(end)){
            begin--;
            end++;
        }

        if(resultLength < end - begin -1){
            resultStart = begin + 1;
            resultLength = end - begin -1;
        }
    }
}
