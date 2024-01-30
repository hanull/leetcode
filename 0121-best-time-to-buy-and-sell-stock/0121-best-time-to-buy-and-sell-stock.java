class Solution {
    public int maxProfit(int[] prices) {
        int max = prices[0];
        int min = prices[0];
        int profit = 0;
        
        for (int i=1; i<prices.length; i++) {
            if (prices[i] > max) {
                max = prices[i];
            }
            if (prices[i] < min) {
                max = min = prices[i];
            }
            profit = Math.max(profit, max - min);
        }
        
        return profit;
    }
}