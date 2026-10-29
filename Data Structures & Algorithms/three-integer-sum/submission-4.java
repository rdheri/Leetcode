class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // nums[j] + nums[k] == -nums[i]

        // [-1,0,1,2,-1,-4]

        List<List<Integer>> result = new ArrayList<>();

        if(nums.length == 0) return result;

        Arrays.sort(nums); // O(nlogn)

        for(int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;

            int j = i+1;

            int k = nums.length - 1;

            int target = -nums[i];

            while(j < k) {
                if(nums[j] + nums[k] == target) {
                    List<Integer> triplets = new ArrayList<>();
                    triplets.add(nums[i]);
                    triplets.add(nums[j]);
                    triplets.add(nums[k]);
                    result.add(triplets);
                    j++;
                    k--;
                }
                else if(nums[j] + nums[k] < target) {
                    j++;
                    while(j < k && nums[j] == nums[j-1]) {
                        j++;
                    }
                }
                else if(nums[j] + nums[k] > target) {
                    k--;
                    while(j < k && nums[k] == nums[k+1]) {
                        k--;
                    } 
                }
            }
        }
        return result;
    }
}
