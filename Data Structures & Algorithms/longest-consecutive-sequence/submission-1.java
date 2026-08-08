class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxL = 0;
    
        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for(int i = 0; i < nums.length; i++) {
            int start;
            if(set.contains(nums[i] - 1)) continue;
            else start = nums[i];

            int curr = 1;
            while(set.contains(nums[i] + curr)) {
                curr++;
            } 
            maxL = Math.max(curr, maxL);
        }
        return maxL;
    }
}
