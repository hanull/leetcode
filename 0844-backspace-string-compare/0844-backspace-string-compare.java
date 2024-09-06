class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stackS = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '#') {
                if (!stackS.isEmpty()) {
                    stackS.pop();
                }
            } else {
                stackS.add(ch);
            }
        }
        
        Stack<Character> stackT = new Stack<>();
        for (char ch : t.toCharArray()) {
            if (ch == '#') {
                if (!stackT.isEmpty()) {
                    stackT.pop();
                }
            } else {
                stackT.add(ch);
            }
        }
        
        if (stackS.size() != stackT.size()) {
            return false;
        }
        
        while (!stackS.isEmpty()) {
            if (stackS.pop() != stackT.pop()) {
                return false;
            }
        }
        
        return true;
    }
}