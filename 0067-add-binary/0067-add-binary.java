class Solution {
    public String addBinary(String a, String b) {
        int lenA = a.length() - 1;
        int lenB = b.length() - 1;
        int carry = 0;
        StringBuilder answer = new StringBuilder();
        
        while (lenA >= 0 || lenB >= 0 || carry == 1) {
            if (lenA >= 0) {
                carry += a.charAt(lenA) - '0';
            }
            if (lenB >= 0) {
                carry += b.charAt(lenB) - '0';
            }
            
            int num = carry % 2;
            answer.append(num);
            
            carry /= 2;
            
            lenA--;
            lenB--;
        }
        
        return answer.reverse().toString();
    }
}