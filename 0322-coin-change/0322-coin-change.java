class Solution {
    
    static final int MAX_VALUE = 10001;
    
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        
        int[] dp = new int[amount + 1];
        int answer = getFewestNumberCoin(coins, amount, dp);
        
        return answer == MAX_VALUE ? -1 : answer;
    }
    
    private int getFewestNumberCoin(int[] coins, int amount, int[] dp) {
        if (amount < 0) {
            return MAX_VALUE;
        }
        if (amount == 0) {
            return 0;
        }
        if (dp[amount] > 0) {
            return dp[amount];
        }
        
        int min = MAX_VALUE;
        for (int coin : coins) {
            min = Math.min(min, getFewestNumberCoin(coins, amount - coin, dp) + 1);
        }
        
        return dp[amount] = min;
    }
}