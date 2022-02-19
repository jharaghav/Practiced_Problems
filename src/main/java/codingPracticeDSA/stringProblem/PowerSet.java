package codingPracticeDSA.stringProblem;
//https://www.youtube.com/watch?v=mEBEw_xScsE
public class PowerSet {

    public static void main(String... s){

        String givenString = "abc";
        int length = givenString.length();
        System.out.println("total possible power set are "+(1<<length));//(2 power n) is equals to 1<<n
        System.out.println("all the power set of given string are ");
        powerSet(givenString, 0,"");
    }

    static void powerSet(String str, int i , String currentString){
        if(i == str.length()) {
            System.out.println(currentString);
            return;
        }
        powerSet(str,i+1, currentString+str.charAt(i)); //here we are including the next character
        powerSet(str,i+1, currentString);//here we are not including the next character
    }


}
