class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            int target = -(nums[i]);
            int k = nums.length-1;
            int j = i + 1;
            while(j < k) {
                if(nums[j] + nums[k] < target) {
                    j++;
                }
                if(nums[j] + nums[k] > target) {
                    k--;
                }
                if(nums[j] + nums[k] == target) {
                    List<Integer> triplets = new ArrayList<>();
                    triplets.add(nums[i]);
                    triplets.add(nums[j]);
                    triplets.add(nums[k]);
                    output.add(triplets);
                    break;
                }
                j++;
                k--;
            }
    }
    return output;
    }
}

