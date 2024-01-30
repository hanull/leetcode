class Solution {
    public boolean isPalindrome(String s) {      
        int left = 0;
        int right = s.length() - 1;
        char[] input = s.toCharArray();
        while (left < right) {
            if (!Character.isAlphabetic(input[left]) && !Character.isDigit(input[left])) {
                left++;
                continue;
            }
            if (!Character.isAlphabetic(input[right]) && !Character.isDigit(input[right])) {
                right--;
                continue;
            }
            if (Character.toLowerCase(input[left]) != Character.toLowerCase(input[right])) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}