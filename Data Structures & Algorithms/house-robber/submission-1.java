class Solution {
    public int rob(int[] nums) {

    // nums = [1,5,7,8,4,5,1,2,3]

    // a) Rob the last house: total loot = loot at last house + loot at last - 2
    // b) Rob the last - 1 house: total loot at n-1th house

    // if there's only one house, return the 1st element
    // if there's 2 houses, return the maximum
    // if there's 3 houses; maximum between 3rd house + 1st house OR 2nd house

    int[] dp = new int[nums.length];
    if(nums.length == 1) return nums[0];
    if(nums.length == 2) return Math.max(nums[0], nums[1]);
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);

    for(int i = 2; i < nums.length; i++) {
        dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
    }

    return dp[nums.length-1];
    }
}
