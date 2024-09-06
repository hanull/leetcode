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
            if (i < romanNumerals.length - 1 && symbolToValue.get(romanNumerals[i]) < symbolToValue.get(romanNumerals[i + 1])) {
                answer -= symbolToValue.get(romanNumerals[i]);
            } else {
                answer += symbolToValue.get(romanNumerals[i]);
            }
        }
        
        return answer;
    }
}