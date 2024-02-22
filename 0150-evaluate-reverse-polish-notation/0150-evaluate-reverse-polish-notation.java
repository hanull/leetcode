class Solution {
    
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for (String token : tokens) {
            if (isOperator(token) && stack.size() >= 2) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.add(calculate(num2, num1, token));
            } else {
                stack.add(Integer.parseInt(token));
            }
        }
        
        return stack.pop();
    }
    
    private boolean isOperator(String token) {
        return Arrays.asList(new String[]{"+", "-", "/", "*"}).contains(token);
    }
    
    private int calculate(int num1, int num2, String operator) {
        if (operator.equals("+")) {
            return num1 + num2;
        }
        if (operator.equals("-")) {
            return num1 - num2;
        }
        if (operator.equals("/")) {
            return num1 / num2;
        }
        if (operator.equals("*")) {
            return num1 * num2;
        }
        return -1;
    }
}