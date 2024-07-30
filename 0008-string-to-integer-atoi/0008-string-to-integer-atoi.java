class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }
        
        char[] arr = s.toCharArray();
        int index = 0;
        while (arr[index] == ' ') {
            index++;
        }
        
        int sign = 1;
        if (index < arr.length && arr[index] == '+' || arr[index] == '-') {
            if (arr[index] == '-') {
                sign = -1;
            }
            index++;
        }
        
        int answer = 0;
        while (index < arr.length && Character.isDigit(arr[index])) {
            if (answer > Integer.MAX_VALUE / 10 || 
               answer == Integer.MAX_VALUE / 10 && arr[index] - '0' > Integer.MAX_VALUE % 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            answer = answer * 10 + (arr[index] - '0');
            index++;
        }
        
        return answer * sign;
    }
}