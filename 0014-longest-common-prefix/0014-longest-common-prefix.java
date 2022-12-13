class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<strs.length - 1; i++) {
             String temp = "";
             for (char c : strs[i].toCharArray()) {
                 temp += c;
                 if (map.containsKey(temp)) {
                     map.put(temp, map.get(temp) + 1);
                 } else {
                     map.put(temp, 1);
                 }
             }
        }
        String answer = "";
        String temp = "";
        for (char c : strs[strs.length - 1].toCharArray()) {
            temp += c;
            if (map.containsKey(temp) && map.get(temp) == strs.length - 1) {
                answer = temp;
            }
        }
        
        return answer;
    }
}