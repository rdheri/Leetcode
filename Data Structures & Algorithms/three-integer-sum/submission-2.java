class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        if(nums.length == 0) return res;

        for(int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int target = -nums[i];
            int j = i+1;
            int k = nums.length - 1;
            while(j < k) {
                if(nums[j] + nums[k] == target) {
                    ArrayList<Integer> triplets = new ArrayList<>();
                    triplets.add(nums[i]);
                    triplets.add(nums[j]);
                    triplets.add(nums[k]);
                    res.add(triplets);
                    j++;
                    k--;
                    while(nums[k] == nums[k+1] && j<k) k--;
                    while(nums[j] == nums[j-1] && j<k) j++;
                }
                if(nums[j] + nums[k] < target) {
                    j++;
                    while(nums[j] == nums[j-1] && j<k) j++;
                }
                if(nums[j] + nums[k] > target) {
                    k--;
                    while(nums[k] == nums[k+1] && j<k) k--;
                }
            }
        }
        return res;
    }
}
