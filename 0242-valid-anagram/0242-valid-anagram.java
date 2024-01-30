class Solution {
    public boolean isAnagram(String s, String t) {
        int[] alphaCount = new int[26];
        
        for (char c : s.toCharArray()) {
            alphaCount[c-'a']++;
        }
        for (char c : t.toCharArray()) {
            alphaCount[c-'a']--;
        }
        
        for (int count : alphaCount) {
            if (count != 0) {
                return false;
            }
        }
        
        return true;
    }
}