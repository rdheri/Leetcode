class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        int max = 0;
        boolean [][] visited = new boolean[grid.length][grid[0].length];

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    max = Math.max(dfs(grid, i, j, visited), max);
                }
            }
        }

        return max;

    }

    public int dfs(int[][] grid, int i, int j, boolean[][] visited) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] || grid[i][j] == 0) return 0;

        visited[i][j] = true;
        int area = 1;

        area += dfs(grid, i+1, j, visited);
        area += dfs(grid, i-1, j, visited);
        area += dfs(grid, i, j+1, visited);
        area += dfs(grid, i, j-1, visited);

        return area;
    }
}
