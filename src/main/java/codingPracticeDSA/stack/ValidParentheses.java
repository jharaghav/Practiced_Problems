package codingPracticeDSA.stack;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String... s){
        String parentheses = "[{[}}]";
        System.out.println("Valid Parentheses : "+isValidParentheses(parentheses));
    }

    public static boolean isValidParentheses(String value){
        Stack<Character> stack = new Stack<>();
        if(value.length() %2 !=0){
            return false;
        }
        for(int i =0;i<value.length();i++){
            char c = value.charAt(i);
            if(c == '{' || c == '[' || c == '('){
                stack.push(c);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }else {
                    char top = stack.peek();
                    if((c == ')' && top == '(')|| (c == '}' && top == '{') || (c == ']' && top == '[')){
                        stack.pop();
                    }else{
                        return false;
                    }

                }
            }
        }
        return stack.isEmpty();
    }
}
