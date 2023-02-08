package coding.easy;

import java.util.Stack;

/**
 * @author: yuzhiwei
 * @description:
 * @create: 2023/2/7 17:22
 **/
public class IsValidBracket {
    public static void main(String[] args) {
        IsValidBracket i = new IsValidBracket();

        System.out.println(i.isValid("[{()}]"));
    }

    public boolean isValid(String s) {
        boolean isValid = true;
        Stack<Character> bracketStack = new Stack<>();

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '['){
                bracketStack.push(c);
            }

            if (c == ')' || c == '}' || c == ']'){
                isValid = hasMatch(bracketStack, c);
            }
        }

        if (!bracketStack.empty()){
            isValid = false;
        }

        return isValid;
    }

    private boolean hasMatch(Stack<Character> bracketStack, char c) {
        if (bracketStack.empty()){
            bracketStack.push(c);
            return false;
        }

        char topC = bracketStack.peek();
        if (topC == getMatch(c)){
            bracketStack.pop();
            return true;
        }else {
            bracketStack.push(c);
        }

        return false;
    }

    private char getMatch(char c) {
        switch (c){
            case ')':
                return '(';
            case '}':
                return '{';
            case ']':
                return '[';
            default:
                return 0;
        }
    }
}
