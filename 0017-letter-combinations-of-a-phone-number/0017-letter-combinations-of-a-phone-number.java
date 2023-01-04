class Solution {
    
    static Map<Character, List<String>> map = new HashMap<>();
    static {
        map.put('2', Arrays.asList("a","b","c"));
        map.put('3', Arrays.asList("d","e","f"));
        map.put('4', Arrays.asList("g","h","i"));
        map.put('5', Arrays.asList("j","k","l"));
        map.put('6', Arrays.asList("m","n","o"));
        map.put('7', Arrays.asList("p","q","r", "s"));
        map.put('8', Arrays.asList("t","u","v"));
        map.put('9', Arrays.asList("w","x","y", "z"));
    }
    
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return new ArrayList<>();
        
        Queue<String> q = new ArrayDeque<>();
        int index = 0;
        while (index < digits.length()) {
            char targetNum = digits.charAt(index);
            if (index==0) {
                for (String str : map.get(targetNum)) {
                    q.add(str);
                }
                index++;
                continue;
            }
            int size = q.size();
            int count = 0;
            while (count < size) {
                String temp = q.poll();
                for (String str : map.get(targetNum)) {
                    q.add(temp + str);
                }
                count++;
            }
            index++;
        }
        
        List<String> answer = new ArrayList<>();
        while (!q.isEmpty()) {
            answer.add(q.poll());
        }
        
        return answer;
    }
}