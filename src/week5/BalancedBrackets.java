import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {
    public static String isBalanced(String s) {
        if (s==null) return "VALID";
        Stack myStack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (a == '(' || a == '[' || a == '{') myStack.push((a));
            else if (myStack.isEmpty()) return "INVALID";
            else {
                if (a == ')'){
                    if ((char) myStack.peek() == '(') myStack.pop();
                    else return "INVALID";
                }
                else if (a == ']') {
                    if ((char) myStack.peek() == '[') myStack.pop();
                    else return "INVALID";
                }
                else if (a == '}') {
                    if ((char) myStack.peek() == '{') myStack.pop();
                    else return "INVALID";
                }
            }
        }
        if(!myStack.isEmpty()) return "INVALID";
        return "VALID";
    }

    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        String string= a.next();
        System.out.println(isBalanced(string));
    }
}
