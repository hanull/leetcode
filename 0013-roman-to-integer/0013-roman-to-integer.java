class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> symbolToValue = new HashMap<>();
        symbolToValue.put('I', 1);
        symbolToValue.put('V', 5);
        symbolToValue.put('X', 10);
        symbolToValue.put('L', 50);
        symbolToValue.put('C', 100);
        symbolToValue.put('D', 500);
        symbolToValue.put('M', 1000);
        
        char[] romanNumerals = s.toCharArray();
        int answer = 0;
        for (int i=0; i<romanNumerals.length; i++) {
            char ch = romanNumerals[i];
            
            if (ch == 'I' && i<romanNumerals.length - 1 && romanNumerals[i + 1] == 'V') {
                answer += 4;
                i++;
                continue;
            }
            
            if (ch == 'I' && i<romanNumerals.length - 1 && romanNumerals[i + 1] == 'X') {
                answer += 9;
                i++;
                continue;
            }
            
            if (ch == 'X' && i<romanNumerals.length - 1 && romanNumerals[i + 1] == 'L') {
                answer += 40;
                i++;
                continue;
            }
            
            if (ch == 'X' && i<romanNumerals.length - 1 && romanNumerals[i + 1] == 'C') {
                answer += 90;
                i++;
                continue;
            }
            
            if (ch == 'C' && i<romanNumerals.length - 1 && romanNumerals[i + 1] == 'D') {
                answer += 400;
                i++;
                continue;
            }
            
            if (ch == 'C' && i<romanNumerals.length - 1 && romanNumerals[i + 1] == 'M') {
                answer += 900;
                i++;
                continue;
            }
            
            answer += symbolToValue.get(ch);
        }
        
        return answer;
    }
}