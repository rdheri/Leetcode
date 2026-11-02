class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left < right) {
            int middle = left + (right - left) / 2;

            if(nums[middle] > nums[right]) {
                left = middle + 1;
            } 
            else {
                right = middle;
            }
        }

        int pivot = left;

        if(target >= nums[pivot] && target <= nums[nums.length-1]) {
            left = pivot;
            right = nums.length - 1;
        }

        else {
            left = 0;
            right = pivot - 1;
        }

        while(left <= right) {
            int middle = left + (right-left) / 2;

            if(nums[middle] == target) return middle;

            else if(nums[middle] < target) {
                left = middle + 1;
            }
            else {
                right = middle - 1;
            }
        }
        return -1;
    }
}
