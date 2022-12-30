class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        if (s.length() <= 1) return s.length();
        
        int answer = 0;
        char[] characters = s.toCharArray();
        Set<Character> sub = new HashSet<>();
        int j=0;
        for (int i=0; i<characters.length; i++) {
            if (sub.contains(characters[i])) {
                sub.remove(characters[j++]);
                i--;
            } else {
                sub.add(characters[i]);
                answer = Math.max(answer, sub.size());
            }
        }
        
        return answer;
    }
}