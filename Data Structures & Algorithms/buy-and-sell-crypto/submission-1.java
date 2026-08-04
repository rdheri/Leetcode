class Solution {
    public int maxProfit(int[] prices) {
        int maxP = 0;
        int left = 0;
        int right = 1;
        while(right < prices.length) {
            int profit = prices[right] - prices[left];
            if(profit < 0) {
                left = right;
            }
            else if(profit > maxP) maxP = profit;
            right++;
        }
        return maxP;     
    }
}
