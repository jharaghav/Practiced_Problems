package codingPracticeDSA.stack;

import java.util.Stack;

/**
 * This class is used for reversing the string with the help of stack
 */
public class ReverseString {
    public static void main(String... s){
        ReverseString reverseString = new ReverseString();
        String value = "abcd";
        System.out.println("Reversed String is: "+reverseString.reverseString(value));

    }

    public String reverseString(String val){
        Stack<Character> stack = new Stack<>();
        char chars[] = val.toCharArray();

        for(char c: chars){
            stack.push(c);
        }

        for(int i=0;i<chars.length;i++){
            chars[i] = stack.pop();
        }

        return new String(chars);
    }
}
