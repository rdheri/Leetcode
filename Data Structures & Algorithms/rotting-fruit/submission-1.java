class Solution {
    public int orangesRotting(int[][] grid) {
          // base: grid is empty or null - return 0
          if(grid == null || grid.length == 0) return 0;

          int fresh = 0;

          Queue<int []> queue = new LinkedList<>();

          for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) fresh++;
                if(grid[i][j] == 2) queue.add(new int [] {i,j});
            }
          }

          if(fresh == 0) return 0;

          int minutesPassed = -1;

          int [][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};

          while(!queue.isEmpty()) {
            int currentLevelSize = queue.size();
            minutesPassed++;

            for(int i = 0; i < currentLevelSize; i++) {
                int [] coordinate = queue.remove();
                int row = coordinate[0];
                int col = coordinate[1];

                for(int [] direction : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];

                    if(newRow < 0 || newCol < 0 || newRow >= grid.length || newCol >= grid[0].length || grid[newRow][newCol] != 1) continue;

                    grid[newRow][newCol] = 2;
                    fresh--;
                    queue.add(new int [] {newRow, newCol});
                }
            }
          }
          if(fresh > 0) return -1;
          else return minutesPassed;
    }
}
