class Solution {
    public int[] plusOne(int[] digits) {
        int index = digits.length - 1;
        while (index >= 0 && digits[index] == 9) {
            digits[index] = 0;
            index--;
        }
        
        if (index < 0) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            return newDigits;
        }
        
        digits[index]++;
        return digits;
    }
}