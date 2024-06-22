class Solution {
    public String addBinary(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        StringBuilder answer = new StringBuilder();
        int temp = 0;
        while (lenA > 0 && lenB > 0) {
            int total = (a.charAt(lenA - 1) - '0') + (b.charAt(lenB - 1) - '0') + temp;
            
            if (total >= 2) {
                temp = 1;
                total -= 2;
            } else {
                temp = 0;
            }
            
            answer.append(total);
            
            lenA--;
            lenB--;
        }
        
        if (lenA > 0) {
            while (lenA > 0) {
                int total = temp + (a.charAt(lenA - 1) - '0');
                
                if (total >= 2) {
                    temp = 1;
                    total -= 2;
                } else {
                    temp = 0;
                }
                
                answer.append(total);
                
                lenA--;
            }
        } else {
            while (lenB > 0) {
                int total = temp + (b.charAt(lenB - 1) - '0');
                
                if (total >= 2) {
                    temp = 1;
                    total -= 2;
                } else {
                    temp = 0;
                }
                
                answer.append(total);
                
                lenB--;
            }
        }
        
        if (temp == 1) {
            answer.append(1);
        }
        
        answer.reverse();
        
        return answer.toString();
    }
}