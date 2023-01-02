class Solution {
    public String longestPalindrome(String s) {
        String answer = "";
        char[] chars = s.toCharArray();
        for (int i=0; i<chars.length; i++) {
            for (int j=chars.length-1; j>=i; j--) {
                if (isPalindrome(i, j, chars)) {
                    String temp = s.substring(i, j + 1);
                    if (temp.length() > answer.length()) {
                        answer = temp;
                    }
                    break;
                }
            }
        }
        return answer;
    }
    
    public boolean isPalindrome(int i, int j, char[] chars) {
        while (i < j) {
            if (chars[i] != chars[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}