class Solution {
    public String mergeAlternately(String word1, String word2) {
        String answer = "";
        int left = 0;
        int right = 0;
        int leftLen = word1.length();
        int rightLen = word2.length();
        
        while (left < leftLen || right < rightLen) {
            if (left < leftLen) {
                answer += word1.charAt(left++);
            }
            if (right < rightLen) {
                answer += word2.charAt(right++);
            }
        }
        
        return answer;
    }
}