class Solution {
    public int longestConsecutive(int[] nums) {

        if(nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums) {
            set.add(num);
        }

        int max = 1;

        for(int i = 0; i < nums.length; i++) {
            int current = 1;

            if(!set.contains(nums[i] + 1)) continue;

            int start = nums[i];

            while(set.contains(start + current)) {
                current++;
            }

            max = Math.max(current, max);
        }

        return max;
    }
}
