class Solution {
    public boolean isPalindrome(int x) {
        String number = String.valueOf(x);
        int left = 0;
        int right = number.length() - 1;
        while (left < right) {
            if (number.charAt(left) != number.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}