class Solution {
    public int maxProfit(int[] prices) {
        int i = 0;
        int len = prices.length - 1;
        int maxProfit = 0;
        int buy = 0;
        int sell = 0;
        while (i < len) {
            while (i < len && prices[i] >= prices[i+1]) {
                i++;
            }
            buy = prices[i];
            
            while (i < len && prices[i] <= prices[i + 1]) {
                i++;
            }
            sell = prices[i];
            
            maxProfit += sell - buy;
        }
        
        return maxProfit;
    }
}