class Solution {
    public String longestPalindrome(String s) {
        String answer = "";
        for (int i=0; i<=s.length() - 1; i++) {
            for (int j=s.length() - 1; j >= i; j--) {
                if (s.charAt(i) == s.charAt(j) && isPalindrom(s.substring(i, j + 1))) {
                    String temp = s.substring(i, j+1);
                    if (answer.length() < temp.length()) {
                        answer = temp;
                    }
                    break;
                }
            }
        }
        
        return answer;
    }
    
    private boolean isPalindrom(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}