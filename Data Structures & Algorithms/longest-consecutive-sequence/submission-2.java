class Solution {
    public int longestConsecutive(int[] nums) {
        int maxL = 0;

        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for(int i = 0; i < nums.length; i++) {
            int start;
            if(set.contains(nums[i] - 1)) continue;
            start = nums[i];
            int curr = 1;
            while(set.contains(start + curr)) {
                curr++;
            }
            maxL = Math.max(curr, maxL);
        }
        return maxL;
    }

}
