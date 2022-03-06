package codingPracticeDSA.stringProblem;
//https://www.youtube.com/watch?v=mEBEw_xScsE
//https://www.youtube.com/watch?v=Yg5a2FxU4Fo    : Best video
public class PowerSet {

    public static void main(String... s){

        String givenString = "abc";
        int length = givenString.length();
        System.out.println("total possible power set are "+(1<<length));//(2 power n) is equals to 1<<n
        System.out.println("all the power set of given string are ");
        //powerSet(givenString, 0,"");

        powerSet("abc", "");
    }

    //https://www.youtube.com/watch?v=Yg5a2FxU4Fo
    static void powerSet(String input, String output){
        if(input.length() == 0){
            System.out.print(output+"-->");
            return;
        }
        String output1 = output;
        String output2 = output+input.charAt(0);

        input = input.substring(1,input.length());
        powerSet(input, output1);
        powerSet(input, output2);
    }

    //https://www.youtube.com/watch?v=mEBEw_xScsE
//    static void powerSet(String str, int i , String currentString){
//        if(i == str.length()) {
//            System.out.println(currentString);
//            return;
//        }
//        powerSet(str,i+1, currentString+str.charAt(i)); //here we are including the next character
//        powerSet(str,i+1, currentString);//here we are not including the next character
//    }


}
