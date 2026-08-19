class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                visited[i][j] = true;
                if(grid[i][j] == '1') {
                    count++;
                    dfs(i,j,grid,visited);
                }
            }
        }
        return count;
    }

    public void dfs(int i, int j, char[][] grid, boolean[][] visited) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || 
        visited[i][j]) {
            return;
        }
        visited[i][j] = true;

        dfs(i,j,grid,visited)
        dfs(i,j,grid,visited)
        dfs(i,j,grid,visited)
        dfs(i,j,grid,visited)
    }
}
