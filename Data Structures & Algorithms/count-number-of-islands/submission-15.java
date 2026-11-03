class Solution {
    public int numIslands(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        boolean[][] visited = new boolean[r][c];

        int count = 0;

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(!visited[i][j] && grid[i][j] == '1') {
                    count++;
                    dfs(grid, visited, i, j);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, boolean[][] visited, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] != '1') return;

        visited[i][j] = true;

        dfs(grid, visited, i + 1, j);
        dfs(grid, visited, i - 1, j);
        dfs(grid, visited, i, j + 1);
        dfs(grid, visited, i, j - 1);
    }
}
