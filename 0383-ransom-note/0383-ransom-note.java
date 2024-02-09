class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        
        int[] magazineCount = new int[26];
        for (char ch : magazine.toCharArray()) {
            magazineCount[ch - 'a']++;
        }
        
        int[] ransomNoteCount = new int[26];
        for (char ch : ransomNote.toCharArray()) {
            ransomNoteCount[ch - 'a']++;
            
            if (magazineCount[ch - 'a'] < ransomNoteCount[ch - 'a']) {
                return false;
            }
        }
        
        return true;
    }
}