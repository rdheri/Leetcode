class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;   

        int fresh = 0;

        Queue<int []> queue = new LinkedList<>();

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    fresh++;
                }
                if(grid[i][j] == 2) {
                    queue.add(new int[] {i,j});
                }
            }
        }

        if(fresh == 0) {
            return 0;
        } 

        int minutesPassed = -1;
        int [][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};

        while(!queue.isEmpty()) {
            int currentLevelSize = queue.size();
            minutesPassed++;

            for(int i = 0; i < currentLevelSize; i++) {
                int [] coord = queue.remove();

                int row = coord[0];

                int col = coord[1];

                for(int [] direction : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];

                    if(newRow < 0 || newCol < 0 || newRow >= grid.length || newCol >= grid[0].length || grid[newRow][newCol] != 1) continue;
                    grid[newRow][newCol] = 2;
                    queue.add(new int[] {newRow, newCol});
                    fresh--;
                }
            }
        }
        if(fresh > 0) return -1;

        return minutesPassed;
    }
}
