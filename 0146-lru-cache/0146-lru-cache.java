class LRUCache {

    private Deque<Integer> q;
    private int maxCapacity;
    private Map<Integer, Integer> cache;
    
    public LRUCache(int capacity) {
        q = new ArrayDeque<>();
        maxCapacity = capacity;
        cache = new HashMap<>();
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        
        q.remove(key);
        q.addFirst(key);
        
        return cache.get(key);
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            q.remove(key);
            q.addFirst(key);
            cache.replace(key, value);
        } else {
            if (q.size() >= maxCapacity) {
                cache.remove(q.pollLast());
            }
            q.addFirst(key);
            cache.put(key, value);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */