package codingPracticeDSA.stringProblem;

public class CountAndSay {

    public static void main(String... s){
        System.out.println("CountAndSay : "+countSay(4));
    }

    public static String countSay(int n) {
        // Base cases
        if (n == 1)     return "1";
        if (n == 2)     return "11";

        String str = "11";
        for (int i = 3; i <= n; i++)
        {
            str += ' ';
            int len = str.length();

            int cnt = 1;
            String tmp = "";
            char []arr = str.toCharArray();

            for (int j = 1; j < len; j++) { //Here we are checking the String value, such as if string is "11 ", then tmp value would be "21"
                if (arr[j] == arr[j - 1]) {
                    cnt++;
                }
                else {
                    tmp += cnt+""+arr[j - 1];
                    cnt = 1;
                }
            }
            str = tmp;
        }
        return str;
    }
}
