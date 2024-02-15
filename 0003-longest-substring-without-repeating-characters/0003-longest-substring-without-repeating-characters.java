class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        
        Set<Character> sub = new HashSet<>();
        sub.add(s.charAt(0));
        int i = 0;
        int j = 1;
        int answer = 1;
        while (i <= j && j < s.length()) {
            if (sub.contains(s.charAt(j))) {
                sub.remove(s.charAt(i));
                i++;
            } else {
                answer = Math.max(answer, j - i + 1);
                sub.add(s.charAt(j));
                j++;
            }
        }
        
        return answer;
    }
}