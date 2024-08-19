class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) {
            return new ArrayList<>();
        }
        
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i=0; i<p.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }
        
        List<Integer> answer = new ArrayList<>();
        for (int i=0; i<s.length() - p.length(); i++) {
            if (isAnagram(sCount, pCount, p.toCharArray())) {
                answer.add(i);
            }
            sCount[s.charAt(i) - 'a']--;
            sCount[s.charAt(i + p.length()) - 'a']++;
        }
        
        if (isAnagram(sCount, pCount, p.toCharArray())) {
            answer.add(s.length() - p.length());
        }
        
        return answer;
    }
    
    private boolean isAnagram(int[] sCount, int[] pCount, char[] pChars) {
        for (char ch : pChars) {
            int index = ch - 'a';
            if (sCount[index] != pCount[index]) {
                return false;
            }
        }
        
        return true;
    }
}