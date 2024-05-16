class Solution {
    public int longestPalindrome(String s) {
        if (s.length() == 1) {
            return 1;
        }
        int answer = 0;
        Set<Character> chars = new HashSet<>();
        for (char ch : s.toCharArray()) {
            if (chars.contains(ch)) {
                answer += 2;
                chars.remove(ch);
            } else {
                chars.add(ch);
            }
        }
        
        if (chars.size() > 0) {
            return answer + 1;
        }
        return answer;
    }
}