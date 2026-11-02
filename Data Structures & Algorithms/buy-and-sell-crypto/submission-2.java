class Solution {
    public int maxProfit(int[] prices) {
      if(prices.length == 0) return 0;

      int left = 0; 
      int right = 1;

      int max = 0;

      while(right < prices.length) {
        int profit = 0;
        if(prices[left] > prices[right]) {
            left = right;
            right++;
        }
        else {
            profit = prices[right] - prices[left];
            right++;
        }
        max = Math.max(profit, max);
      }  
      return max;
    }
}
