class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh_count = 0;

        Queue<int[]> queue = new LinkedList<>();

        int row = grid.length, col = grid[0].length;

        // Populate the queue and calculate the number of fresh fruits
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 1) fresh_count++;
                if(grid[i][j] == 2) queue.add(new int[] {i,j});
            }
        }

        int [][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int currentTime = 0;

        while(!queue.isEmpty() && fresh_count > 0) {
            int size = queue.size();
            currentTime++;
            for(int i = 0; i < size; i++) {
                int[] c = queue.remove();
                int rows = c[0];
                int column = c[1];
                for(int [] direction : directions) {
                    int newRow = rows + direction[0];
                    int newCol = column + direction[1];

                    if(newCol < 0 || newRow < 0 || newCol >= grid[0].length || newRow >= grid.length || grid[newRow][newCol] != 1) continue;
                    grid[newRow][newCol] = 2;
                    queue.add(new int[] {newRow, newCol});
                    fresh_count--;
                }
            }
        }
        if(fresh_count > 0) return -1;
        else return currentTime;
    }
}
