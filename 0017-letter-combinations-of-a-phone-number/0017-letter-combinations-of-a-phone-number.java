class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        
        Map<Character, List<String>> map = new HashMap<>();
        map.put('2', List.of("a", "b", "c"));
        map.put('3', List.of("d", "e", "f"));
        map.put('4', List.of("g", "h", "i"));
        map.put('5', List.of("j", "k", "l"));
        map.put('6', List.of("m", "n", "o"));
        map.put('7', List.of("p", "q", "r", "s"));
        map.put('8', List.of("t", "u", "v"));
        map.put('9', List.of("w", "x", "y", "z"));
        
        List<String> answer = new ArrayList<>();
        dfs(digits, 0, digits.length(), new StringBuilder(), map, answer);
        
        return answer;
    }
    
    private void dfs(String digits, int index, int n, StringBuilder letter, Map<Character, List<String>> map, List<String> answer) {
        if (index == n) {
            answer.add(letter.toString());
            return;
        }
        
        for (String s : map.get(digits.charAt(index))) {
            letter.append(s);
            dfs(digits, index + 1, n, letter, map, answer);
            letter.deleteCharAt(index);
        }
    }
}