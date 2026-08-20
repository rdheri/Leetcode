class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        boolean [][] visited = new boolean [grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(!visited[i][j] && grid[i][j] == '1') {
                    count++;
                    numIslands(i, j, grid, visited);
                }
            }
        }
        return count;
    }

    public void numIslands(int i, int j, char[][] grid, boolean[][] visited) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0'
        || visited[i][j]) return;
        visited[i][j] = true;
        numIslands(i + 1,j,grid,visited); // bottom
        numIslands(i - 1,j,grid,visited); // top
        numIslands(i,j + 1,grid,visited); // right
        numIslands(i,j - 1,grid,visited); // left
    }
}
