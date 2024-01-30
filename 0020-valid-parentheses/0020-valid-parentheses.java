class Solution {
    
    public boolean isValid(String s) {
        Stack<Character> brackets = new Stack<>();
        
        for (char bracket : s.toCharArray()) {
            if (bracket == '(' || bracket == '{' || bracket == '[') {
                brackets.add(bracket);
                continue;
            }
            
            if (bracket == ')') {
                if (brackets.isEmpty() || brackets.peek() != '(') {
                    return false;
                }
                brackets.pop();
            } else if (bracket == '}') {
                if (brackets.isEmpty() || brackets.peek() != '{') {
                    return false;
                }
                brackets.pop();
            } else {
                if (brackets.isEmpty() || brackets.peek() != '[') {
                    return false;
                }
                brackets.pop();
            }
        }
        
        return brackets.isEmpty();
    }
}