class Solution {
    public int[] twoSum(int[] nums, int target) {
        // [1,2,3,7,5], Target = 6, Return [0,4]

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
