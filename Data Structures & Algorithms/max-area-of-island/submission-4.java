class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int area = 0;

        boolean[][] visited = new boolean[grid.length][grid[0].length];   

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    area = Math.max(dfs(i, j, visited, grid), area);
                }
            }
        }
        return area;
    }

    public int dfs(int i, int j, boolean[][] visited, int[][] grid) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] || grid[i][j] != 1) return 0;

        visited[i][j] = true;

        int sum = 1;

        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        for(int [] direction : directions) {
            sum += dfs(i + direction[0], j + direction[1], visited, grid);
        }

        return sum;

    }
}
