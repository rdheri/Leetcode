class Solution {
    public int maxProfit(int[] prices) {
        int right = 1;
        int left = 0;
        int p = 0;
        int maxP = 0;
        while(right < prices.length) {
            p = prices[right] - prices[left];
            if(p > maxP) {
                maxP = p;
            }
            else if(p < 0) left = right;
            right++;
        }
        return maxP;
        }  
    }

