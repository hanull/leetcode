class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }
        Arrays.sort(count);
        
        int maxPartCount = count[25] - 1;
        int empty = maxPartCount * n;
        for (int i=24; i>=0; i--) {
            empty -= Math.min(maxPartCount, count[i]);
        }
        empty = Math.max(0, empty);
        
        return tasks.length + empty;
    }
}