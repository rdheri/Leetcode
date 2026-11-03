class Solution {
    public void islandsAndTreasure(int[][] grid) {
        // -1: Water, 0: Treasure, INF: Land

        Queue<int []> queue = new LinkedList<>();

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(!visited[i][j] && grid[i][j] == 0) {
                    queue.add(new int[] {i,j});
                }
            }
        }
        int distance = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            distance++;

            for(int i = 0; i < size; i++) {
                int [] coordinate = queue.remove();
                int x = coordinate[0];
                int y = coordinate[1];
                if(visited[x][y]) continue;
                visited[x][y] = true;
                int[][] directions = {{0,1}, {1,0}, {-1,0}, {0,-1}};

                for(int [] direction : directions) {
                    int nr = x + direction[0];
                    int nc = y + direction[1];

                    if(nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length || visited[nr][nc] || grid[nr][nc] != 2147483647) continue;

                    grid[nr][nc] = distance;
                    queue.add(new int[] {nr, nc});
                }
            }            
        }
    }
}
