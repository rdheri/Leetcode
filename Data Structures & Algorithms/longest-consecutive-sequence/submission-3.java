class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int maxL = 0;

        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }

        for(int i = 0; i < nums.length; i++) {
            int start;
            if(map.containsKey(nums[i] - 1)) continue;
            start = nums[i];
            int curr = 1;
            while(map.containsKey(start + curr)) {
                curr++;
            }
            maxL = Math.max(curr, maxL);
        }

        return maxL;
        
    }
}
