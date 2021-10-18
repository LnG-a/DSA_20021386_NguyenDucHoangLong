public class BalancedBrackets {
    /**
     * This method check if the String is BalancedBrackets.
     * Complexity O(N)
     *
     * @param s is a String
     * @return YES if true, No if false
     */
    public static String isBalanced(String s) {
        Stack myStack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (a == '(' || a == '[' || a == '{') myStack.push((a));
            else if (myStack.isEmpty()) return "NO";
            else {
                if (a == ')'){
                    if ((char) myStack.peek() == '(') myStack.pop();
                    else return "NO";
                }
                else if (a == ']') {
                    if ((char) myStack.peek() == '[') myStack.pop();
                    else return "NO";
                }
                else if (a == '}') {
                    if ((char) myStack.peek() == '{') myStack.pop();
                    else return "NO";
                }
            }
        }
        if(!myStack.isEmpty()) return "NO";
        return "YES";
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("{[()]}]"));
    }
}
