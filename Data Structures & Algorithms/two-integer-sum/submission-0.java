class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> counts = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(counts.containsKey(complement)) return new int [] {counts.get(complement), i};
                    counts.put(nums[i], i);

        }
        return new int[] {};
    }
    }
