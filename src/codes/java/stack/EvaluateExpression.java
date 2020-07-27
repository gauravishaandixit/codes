package codes.java.stack;

import java.util.Stack;

public class EvaluateExpression {

    int evalRPN(String[] tokens) {

        int a,b;

        Stack<Integer> S = new Stack<Integer>();

        for (String s : tokens) {
            if(s.equals("+")) {
                S.push(S.pop()+S.pop());
            }
            else if(s.equals("/")) {
                b = S.pop();
                a = S.pop();
                S.push(a / b);
            }
            else if(s.equals("*")) {
                S.push(S.pop() * S.pop());
            }
            else if(s.equals("-")) {
                b = S.pop();
                a = S.pop();
                S.push(a - b);
            }
            else {
                S.add(Integer.parseInt(s));
            }
        }
        return S.pop();
    }
    public static void main(String[] ar)
    {
        System.out.println(new EvaluateExpression().evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(new EvaluateExpression().evalRPN(new String[]{"4", "13", "5", "/", "+"}));
    }
}
