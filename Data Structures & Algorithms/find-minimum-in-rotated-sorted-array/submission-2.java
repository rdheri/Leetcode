class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int min = 0;
        int mid = 0;

        

        while(left < right) {
            mid = left + ((right-left)/2);

            if((nums[mid+1] > nums[mid] && mid != nums.length-1) && (nums[mid-1] > nums[mid] && mid != 0)) return nums[mid];

            else if(nums[mid] < nums[mid+1] && nums[mid] > nums[mid-1]) {
                left = mid+1;
            }

            else right = mid;
        }
        min = nums[left];
        return Math.min(nums[mid], min);
    }
}
