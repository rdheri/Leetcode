class Solution {
    public int numIslands(char[][] grid) {
        boolean [][] visited = new boolean[grid.length][grid[0].length];

        int islands = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    islands+=1;
                    dfs(grid, i, j, visited);
                }
            }
        }
        return islands;
    }

    public void dfs(char[][] grid, int i, int j, boolean [][] visited) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0' || visited[i][j]) return;
        visited[i][j] = true;

        dfs(grid, i+1, j, visited);
        dfs(grid, i-1, j, visited);
        dfs(grid, i, j+1, visited);
        dfs(grid, i, j-1, visited);
    }
}
