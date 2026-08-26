class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean [grid.length][grid[0].length];

        int area = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(!visited[i][j] && grid[i][j] == 1) {
                    area = Math.max(area,dfs(grid, i, j, visited));
                }
            }
        }
        return area;
    }

    public int dfs(int[][] grid, int i, int j, boolean [][] visited) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] || grid[i][j] == 0) return 0;

        int sum = 1;
        visited[i][j] = true;

        sum += dfs(grid, i+1, j, visited);
        sum += dfs(grid, i, j+1, visited);
        sum += dfs(grid, i-1, j, visited);
        sum += dfs(grid, i, j-1, visited);

        return sum;
        
    }
}
