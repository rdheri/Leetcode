class Solution {
    public int evalRPN(String[] tokens) {
        // tokens = ["1","2","+","3","*","4","-"]

        if (tokens.length == 0) return 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {

            String s = tokens[i];

            if (!s.equals("+") && !s.equals("*") &&
                !s.equals("-") && !s.equals("/")) {

                stack.push(Integer.parseInt(s));
            }
            else {
                String operation = s;

                int operandB = stack.pop();
                int operandA = stack.pop();

                stack.push(compute(operandA, operandB, operation));
            }
        }

        return stack.pop();
    }

    public int compute(int operandA, int operandB, String s) {

        if (s.equals("+")) {
            return operandA + operandB;
        }
        else if (s.equals("/")) {
            return operandA / operandB;
        }
        else if (s.equals("-")) {
            return operandA - operandB;
        }
        else if (s.equals("*")) {
            return operandA * operandB;
        }
        else throw new IllegalArgumentException();
    }
}
