class Solution {
    public int maxArea(int[] heights) {
        // 1,7,2,5,4,7,3,6

        if(heights.length == 0) return 0;

        int left = 0;

        int right = heights.length - 1;

        int max = -1;

        while(left < right) {
            int current = (right - left) * Math.min(heights[left], heights[right]);

            if(current > max) max = current;

            if(heights[right] > heights[left]) {
                left++;
            }
            else right--;
        }

        return max;
    }
}
