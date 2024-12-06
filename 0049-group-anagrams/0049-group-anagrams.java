class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> keys = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String temp = String.valueOf(chars);
            
            List<String> values;
            if (keys.containsKey(temp)) {
                values = keys.get(temp);
            } else {
                values = new ArrayList<>();
            }
            values.add(str);
            keys.put(temp, values);
        }
        
        List<List<String>> answer = new ArrayList<>();
        for (String key : keys.keySet()) {
            List<String> values = keys.get(key);
            Collections.sort(values);
            answer.add(values);
        }
        
        return answer;
    }
}