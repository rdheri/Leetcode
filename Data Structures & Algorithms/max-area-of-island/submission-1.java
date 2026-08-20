class Solution {
    int max = 0;
    public int maxAreaOfIsland(int[][] grid) {
        boolean [][] visited = new boolean [grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    max = Math.max(max, areaOfSingleIsland(grid, i, j, visited));
                }
            }
        }
        return max;
    }

    public int areaOfSingleIsland(int[][] grid, int i, int j, boolean[][] visited) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || visited[i][j]) return 0;

        int sum = 1;
        visited[i][j] = true;

        sum += areaOfSingleIsland(grid, i+1, j, visited);
        sum += areaOfSingleIsland(grid, i, j+1, visited);
        sum += areaOfSingleIsland(grid, i-1, j, visited);
        sum += areaOfSingleIsland(grid, i, j-1, visited);

        return sum;
    }
}
