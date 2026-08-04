class Solution {
    public int maxArea(int[] heights) {
        int maxWater = 0;
        int left = 0;
        int right = heights.length - 1;
        while (left < right) {
            int currentArea = (right - left) * Math.min(heights[right], heights[left]);
            maxWater = Math.max(currentArea, maxWater);
            if(heights[right] > heights[left]) {
                left++;
            }
            else if(heights[left] > heights[right]) {
                right--;
            }
            else {
                left++;
            right--;
            }
        }
        return maxWater;
    }
}
