class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        
        String answer = "";
        int maxLength = 0;
        for (int i=0; i< s.length(); i++) {
            for (int j=s.length() - 1; j >= i + maxLength; j--) {
                if (s.charAt(i) == s.charAt(j) && isPalindrom(s.substring(i, j + 1))) {
                    String temp = s.substring(i, j+1);
                    if (temp.length() > maxLength) {
                        answer = temp;
                        maxLength = temp.length();
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