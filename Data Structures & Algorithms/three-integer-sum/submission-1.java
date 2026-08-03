class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            int target = -(nums[i]);
            int k = nums.length-1;
            int j = i + 1;
            if(i > 0 && nums[i] == nums[i-1]) continue;

            while(j < k) {
                if(nums[j] + nums[k] < target) {
                    j++;
                }
                else if(nums[j] + nums[k] > target) {
                    k--;
                }
                else {
                    List<Integer> triplets = new ArrayList<>();
                    triplets.add(nums[i]);
                    triplets.add(nums[j]);
                    triplets.add(nums[k]);
                    output.add(triplets);
                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j-1]) j++;
                    while(j < k && nums[k] == nums[k+1]) k--;

                }
            }
    }
    return output;
    }
}

