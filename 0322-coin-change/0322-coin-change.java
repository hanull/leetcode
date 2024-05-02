class Solution {
    
    static final int MAX_VALUE = 10001;
    
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, MAX_VALUE);
        dp[0] = 0;
        
        for (int target=1; target<=amount; target++) {
            for (int coin : coins) {
                if (target < coin) {
                    break;
                }
                dp[target] = Math.min(dp[target], dp[target - coin] + 1);
            }
        }
        
        return dp[amount] == MAX_VALUE ? -1 : dp[amount];
    }
}