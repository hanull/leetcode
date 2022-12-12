class Solution {
    
    static Map<String, Integer> map = new HashMap<>();
    static {
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
    }
    
    public int romanToInt(String s) {
        if (s.length() == 1) {
            return map.get(s);
        }
        
        String[] input = s.split("");
        Stack<String> stack = new Stack<>();
        for (String alpa : input) {
            if (stack.isEmpty()) {
                stack.add(alpa);
                continue;
            }
            if (map.get(stack.peek()) < map.get(alpa)) {
                String newAlpa = stack.pop() + alpa;
                stack.add(newAlpa);
            } else {
                stack.add(alpa);
            }
        }
        
        int answer = 0;
        while (!stack.isEmpty()) {
            answer += map.get(stack.pop());
        }
        return answer;
    }
}