class Solution {
    public boolean hasDuplicate(int[] nums) {
        // [1, 2, 3, 4]
        // Edge: Input is Empty, Return False
        // Edge: If input size is 1, Return False

        if(nums.length == 0 || nums.length == 1) return false;

        HashSet<Integer> set = new HashSet<>();

        for(int num : nums) {
            if(set.contains(num)) return true;
            set.add(num);
        }

        return false;
        
    }
}