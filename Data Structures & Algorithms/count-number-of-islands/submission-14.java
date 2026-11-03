class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int num = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(!visited[i][j] && grid[i][j] == '1') {
                    num++;
                    dfs(grid, visited, i, j);
                }
            }
        }
        return num;    
    }
    public void dfs(char[][] grid, boolean[][] visited, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] == '0') {
            return;
        }
        visited[i][j] = true;

        int[][] directions = {{-1,0}, {0,-1}, {1,0}, {0,1}};

        for(int [] direction : directions) {
            int nr = i + direction[0];
            int nc = j + direction[1];
            dfs(grid, visited, nr, nc);
        }
    }
}
