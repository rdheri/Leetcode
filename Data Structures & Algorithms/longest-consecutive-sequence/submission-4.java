class Solution {
    public int longestConsecutive(int[] nums) {
        // [2, 20, 4, 10, 3, 4, 5]

        // Start : Array doesn't contain n-1 number

        if(nums.length == 0) return 0;

        int maxL = 0;

        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        // Set : 2, 20, 4, 10, 3, 4, 5

        for(int i = 0; i < nums.length; i++) {
            int start;
            if(set.contains(nums[i] - 1)) continue;
            start = nums[i];
            int curr = 0;
            while(set.contains(start + curr)) {
                curr = curr + 1;
            }
            maxL = Math.max(curr, maxL);
        }
        return maxL;
    }
}
