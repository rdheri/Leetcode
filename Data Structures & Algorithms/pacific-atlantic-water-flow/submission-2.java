class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        if(heights == null || heights.length == 0) return res;

        boolean pacific [][] = new boolean[heights.length][heights[0].length];
        boolean atlantic [][] = new boolean[heights.length][heights[0].length];

        for(int i = 0; i < heights.length; i++) {
            dfs(heights, i, 0, pacific);
            dfs(heights, i, heights[0].length - 1, atlantic);
        }

        for(int j = 0; j < heights[0].length; j++) {
            dfs(heights, 0, j, pacific);
            dfs(heights, heights.length-1, j, atlantic);
        }

        for(int i = 0; i < heights.length; i++) {
            for(int j = 0; j < heights[0].length; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }

    public void dfs(int [][] grid, int i, int j, boolean[][] visited) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};

        for(int [] direction : directions) {
            int nr = i + direction[0];
            int nc = j + direction[1];
            if(nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length || visited[nr][nc]) continue;
            if(grid[nr][nc] >= grid[i][j]) {
                dfs(grid, nr, nc, visited);
            }
        }
    }
}
