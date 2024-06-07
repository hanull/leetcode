class TimeMap {
    
    private static class Node {
        String value;
        int timestamp;
        
        public Node(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
    
    private Map<String, List<Node>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!timeMap.containsKey(key)) {
            timeMap.put(key, new ArrayList<>());
        }
        timeMap.get(key).add(new Node(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key)) {
            return "";
        }
        
        List<Node> nodes = timeMap.get(key);
        int left = 0;
        int right = nodes.size() - 1;
        
        int index = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (nodes.get(mid).timestamp <= timestamp) {
                index = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return index == -1 ? "" : nodes.get(index).value;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */