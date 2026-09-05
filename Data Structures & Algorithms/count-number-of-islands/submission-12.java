class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        boolean [][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(!visited[i][j] && grid[i][j] == '1') {
                    count++;
                    dfs(visited, i, j, grid);
                }
            }
        }
        return count;
    }

    public void dfs(boolean[][] visited, int i, int j, char[][] grid) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] || grid[i][j] != '1') {
            return;
        }
        visited[i][j] = true;

        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};

        for(int [] direction : directions) {
            dfs(visited, i + direction[0], j + direction[1], grid);
        }
    }
}
