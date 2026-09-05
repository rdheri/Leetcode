class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid.length == 0) return 0;

        int freshCount = 0;
        int minutes = 0;

        Queue<int []> queue = new LinkedList();

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) freshCount++;
                if(grid[i][j] == 2) queue.add(new int[] {i,j});
            }
        }

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        while(!queue.isEmpty() && freshCount > 0) {
            int currentSize = queue.size();
            int [] cord = queue.remove();
            
            visited[cord[0]][cord[1]] = true;

            minutes++;

            int[][] directions = {{0,1}, {1,0}, {-1,0}, {0,-1}};

            for(int [] direction : directions) {
                int nr = cord[0] + direction[0];
                int nc = cord[1] + direction[1];

                if(nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length || grid[nr][nc] != 1 || visited[nr][nc]) continue;
                queue.add(new int[] {nr, nc});
                freshCount--;
            }
        }
        if(freshCount > 0) minutes = -1;
        return minutes;
    }
}
