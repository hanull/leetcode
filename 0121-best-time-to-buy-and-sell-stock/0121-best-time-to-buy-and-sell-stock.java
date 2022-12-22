class Solution {
    public int maxProfit(int[] prices) {
        int answer = 0;
        int buyPrice = prices[0];
        for (int i=1; i<prices.length; i++) {
            answer = Math.min(answer, buyPrice - prices[i]);
            buyPrice = Math.min(buyPrice, prices[i]);
        }
        return Math.abs(answer);
    }
}