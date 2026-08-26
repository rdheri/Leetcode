class Solution {
    public int orangesRotting(int[][] grid) {
        int minutes = 0, freshCount = 0;

        Queue<int[]> queue = new LinkedList<>();

        boolean [][] visited = new boolean[grid.length][grid[0].length];

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(!visited[i][j] && grid[i][j] == 1) {
                    freshCount++;
                }
                if(!visited[i][j] && grid[i][j] == 2) {
                    queue.add(new int[] {i,j});
                }
            }
        }
        while(!queue.isEmpty() && freshCount > 0) {
            int currentSize = queue.size();
            minutes++;
            for(int i = 0; i < currentSize; i++) {
                int [] coordinates = queue.remove();
                int x = coordinates[0];
                int y = coordinates[1];

                visited[x][y] = true;
                int[][] directions = {{-1,0}, {0,-1}, {0,1}, {1,0}};

                for(int [] direction : directions) {
                    int nr = x + direction[0];
                    int nc = y + direction[1];

                    if(nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length || visited[nr][nc] || grid[nr][nc] != 1) continue;
                    grid[nr][nc] = 2;
                    freshCount--;
                    queue.add(new int[] {nr, nc});
                }
            }
            }   
            if(freshCount > 0) return -1;
            else return minutes; 
            }
}
