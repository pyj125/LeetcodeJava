package history;

import java.util.Stack;

public class LeetCode150 {



    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; ++i) {
            String s = tokens[i];
            String first = "";
            String second = "";
            String res = "";
            int temp = 0;
            switch (s) {
                case "+":
                    second = stack.pop();
                    first = stack.pop();
                    temp = Integer.parseInt(first) + Integer.parseInt(second);
                    stack.push(temp+"");
                    break;
                case "-":
                    second = stack.pop();
                    first = stack.pop();
                    temp = Integer.parseInt(first) - Integer.parseInt(second);
                    stack.push(temp+"");
                    break;
                case "*":
                    second = stack.pop();
                    first = stack.pop();
                    temp = Integer.parseInt(first) * Integer.parseInt(second);
                    stack.push(temp+"");
                    break;
                case "/":
                    second = stack.pop();
                    first = stack.pop();
                    temp = Integer.parseInt(first) / Integer.parseInt(second);
                    stack.push(temp+"");
                    break;
                default:
                    stack.push(s);
            }
        }
        String result = stack.pop();
//        System.out.println(result);
        return Integer.parseInt(result);
    }
}
