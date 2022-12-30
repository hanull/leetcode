class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        if (s.length() <= 1) return s.length();
        
        int answer = 0;
        char[] characters = s.toCharArray();
        for (int i=0; i<characters.length; i++) {
            Set<Character> sub = new HashSet<>();
            sub.add(characters[i]);
            for (int j=i+1; j<characters.length; j++) {
                if (sub.contains(characters[j])) {
                    break;
                }
                sub.add(characters[j]);
            }
            answer = Math.max(answer, sub.size());
        }
        
        return answer;
    }
}