class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int maxL = 0;
        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i] - 1)) continue;
            else {
                int current = 1;
                while(set.contains(nums[i] + current)) {
                    current++;
                }
                maxL = Math.max(maxL, current);
            }
        } 
        return maxL;
    }
}
