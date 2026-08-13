class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = searchPotentialRow(matrix, target);
        return searchRow(matrix, row, target);
    }

    public int searchPotentialRow(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length-1;

        while(left < right) {
            int mid = left + ((right-left)/2);
            if(matrix[mid][0] <= target && target < matrix[mid+1][0]) {
                return mid;
            }
            else if(matrix[mid][0] > target) {
                right = mid;
            }
            else if(matrix[mid][0] < target) {
                left = mid+1;
            }
        }
        return - 1;
    }

        public boolean searchRow(int[][] matrix, int row, int target) {
            if(row == -1) return false;

            int left = 0;
            int right = matrix[0].length - 1;

            while(left < right) {
                int mid = left + ((right - left)/2);
                if(matrix[row][mid] == target) return true;
                else if(matrix[row][mid] < target) {
                    right = mid;
                }
                else if(matrix[row][mid] > target) {
                    left = mid + 1;
                }
            }
            return false;
        }
}
