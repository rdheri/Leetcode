class Solution {
    public int orangesRotting(int[][] grid) {
        boolean visited[][] = new boolean[grid.length][grid[0].length];

        int freshCount = 0;

        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(!visited[i][j] && grid[i][j] == 2) {
                    queue.add(new int[] {i,j});
                }
                if(!visited[i][j] && grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        int minutes = 0;

        while(!queue.isEmpty() && freshCount > 0) {
            int size = queue.size();

            minutes++;

            for(int i = 0; i < size; i++) {
                int [] coordinate = queue.remove();
                int x = coordinate[0];
                int y = coordinate[1];

                if(visited[x][y]) continue;

                visited[x][y] = true;

                int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};

                for(int [] direction : directions) {
                    int nr = x + direction[0];
                    int nc = y + direction[1];

                    if(nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length || grid[nr][nc] != 1) continue;

                    grid[nr][nc] = 2;
                    freshCount--;

                    queue.add(new int[] {nr, nc});
                }
            }

        }
        if(freshCount == 0) return minutes;

        return -1;
    }
}
