class Solution {
    public int climbStairs(int n) {
        // n = 7;

        // - - - - - - -

        // number of ways to get to n = n-1 + n-2

        int [] dp = new int [n+1];

        dp[1] = 1;

        dp[2] = 2;

        for(int i = 3; i < n+1; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[dp.length-1];
    }
}
