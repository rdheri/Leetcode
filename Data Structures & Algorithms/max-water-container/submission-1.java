class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int left = 0;
        int right = heights.length - 1;

        while(left < right) {
            int currentArea = Math.min(heights[left],heights[right]) * (right - left);
            maxArea = Math.max(currentArea, maxArea);
            if(heights[left] < heights[right]) {
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

        return maxArea;
    }
}
