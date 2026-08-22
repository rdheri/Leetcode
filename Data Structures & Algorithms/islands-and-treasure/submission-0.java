class Solution {
    public void islandsAndTreasure(int[][] grid) {
        if(grid == null || grid.length == 0) return;

        Queue<int []> queue = new LinkedList<>();
        boolean visited [][] = new boolean[grid.length][grid[0].length];

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0) queue.add(new int[] {i, j});
            }
        }

        int[][] directions = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        
        int distance = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            distance++;

            for(int i = 0; i < size; i++) {
                int[] coordinate = queue.remove();
                int row = coordinate[0];
                int col = coordinate[1];
                visited[row][col] = true;

                for(int [] direction : directions) {
                    int nr = row + direction[0];
                    int nc = col + direction[1];

                    if(nc < 0 || nr < 0 || nr >= grid.length || nc >= grid[0].length || visited[nr][nc] || grid[nr][nc] != Math.pow(2,31) - 1) continue;
                    grid[nr][nc] = distance;
                    queue.add(new int[] {nr, nc});
                }
            }
        }
    }
}
