class Solution {
    public int maxArea(int[] heights) {
        // [1,7,2,5,4,7,3,6] 

        if(heights.length == 0) return 0;

        int left = 0;

        int right = heights.length - 1;

        int max = 0;

        while(left < right) {
            int width = right - left;
            int height = Math.min(heights[left], heights[right]);

            int current = height * width;

            if(max < current) max = current;

            if(heights[left] < heights[right]) {
                left++;
            }
            else right--;
        }

        return max;
    }
}
