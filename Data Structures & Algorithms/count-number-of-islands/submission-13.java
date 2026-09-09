class Solution {
    public int numIslands(char[][] grid) {
        int numIslands = 0;
        boolean [][] visited = new boolean[grid.length][grid[0].length];

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    numIslands++;
                    dfs(grid, i, j, visited);
                }
            }
        }
        return numIslands;
    }

    public void dfs(char[][] grid, int i, int j, boolean[][] visited) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] ||
        grid[i][j] != '1') return;

        visited[i][j] = true;

        int[][] directions = {{-1, 0}, {0,-1}, {1,0}, {0,1}};

        for(int [] direction : directions) {
            int nr = i + direction[0];
            int nc = j + direction[1];
            dfs(grid, nr, nc, visited);
        }
    }
}
