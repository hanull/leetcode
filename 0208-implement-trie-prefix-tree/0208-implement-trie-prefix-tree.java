class Trie {

    List<String> container;
    
    public Trie() {
        container = new ArrayList<>();
    }
    
    public void insert(String word) {
        if (!container.contains(word)) {
            container.add(word);
        }
    }
    
    public boolean search(String word) {
        return container.contains(word);
    }
    
    public boolean startsWith(String prefix) {
        if (container.isEmpty()) {
            return false;
        }
        
        container.sort(String::compareTo);
        
        int left = 0;
        int right = container.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            
            String word = container.get(mid);
            if (word.compareTo(prefix) >= 0) {
                if (isIncludePrefix(word, prefix)) {
                    return true;
                } else {
                    right = mid - 1;
                }
            } else {
                left = mid + 1;
            }
        }
        
        return false;
    }
    
    private boolean isIncludePrefix(String word, String prefix) {
        if (word.length() < prefix.length()) {
            return false;
        }
        
        for (int i=0; i<prefix.length(); i++) {
            if (prefix.charAt(i) != word.charAt(i)) {
                return false;
            }
        }
        
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */