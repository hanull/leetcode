class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        
        Arrays.sort(citations);
        
        for (int i=0; i<len; i++) {
            // citations[i]회 이상 인용된 논문의 수
            int h = len - i;
            
            // 인용 횟수가 논문의 수(h) 이상이 된 경우, 논문의 수가 h-index가 된다.
            if (citations[i] >= h) {
                return h;
            }
        }
        
        return 0;
    }
}