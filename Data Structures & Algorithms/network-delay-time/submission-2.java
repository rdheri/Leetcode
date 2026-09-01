class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // 1 to n

        // times [i] : edge from times[0] to times[1] with cost times[2]

        // k : source node 

        List<List<int[]>> graph = new ArrayList<>();

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<int[]>());
        }

        int[] distances = new int [n+1];

        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[k] = 0;

        for(int [] edge : times) {
            int source = edge[0];
            int dest = edge[1];
            int cost = edge[2];
            graph.get(source).add(new int [] {dest, cost});
        } 

        boolean[] visited = new boolean [n+1];

        PriorityQueue<int []> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        pq.add(new int[] {k, 0});

        while(!pq.isEmpty()) {
            int [] curr = pq.remove();
            int node = curr[0];
            int cost = curr[1];

            if(visited[node]) continue;

            visited[node] = true;

            for(int [] edge : graph.get(node)) {
                int dest = edge[0];
                int price = edge[1];

                if(cost + price < distances[dest]) {
                    distances[dest] = cost + price;
                    pq.add(new int [] {dest, cost+price});
                }
            }
        }
        int max = 0;
        for(int i = 1; i < n+1; i++) {
            if(distances[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, distances[i]);
        }
        return max;
    }
}
