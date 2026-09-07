class Solution {
    public int minCostClimbingStairs(int[] cost) {
       int[] dp = new int[cost.length];

       if(cost.length == 1) return cost[0];
       if(cost.length == 2) return Math.min(cost[0], cost[1]);

       dp[0] = cost[0];
       dp[1] = cost[1];

       for(int i = 2; i < cost.length; i++) {
        dp[i] = Math.min(cost[i] + dp[i-2], cost[i] + dp[i-1]);
       }

     return Math.min(dp[cost.length-1], dp[cost.length-2]);

    }

    // cost=[1,2,1,2,1,1,1]
    // dp = [1,2,2, ]
}
