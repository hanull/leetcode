class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Map<String, Boolean> cache = new HashMap<>();
        
        return dfs(s, dict, cache);
    }
    
    private boolean dfs(String s, Set<String> dict, Map<String, Boolean> cache) {
        if (s.length() == 0) {
            return true;
        }
        
        if (cache.containsKey(s)) {
            return cache.get(s);
        }
        
        for (int i=1; i<=s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i, s.length());
            
            if (dict.contains(left) && dfs(right, dict, cache)) {
                cache.put(s, true);
                return true;
            }
        }
        cache.put(s, false);
        return false;
    }
}