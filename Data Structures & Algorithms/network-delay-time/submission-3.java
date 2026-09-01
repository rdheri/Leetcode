class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        if(n == 0) return 0;

        int[] distances = new int[n+1];

        Arrays.fill(distances, Integer.MAX_VALUE);

        List<List<int []>> graph = new ArrayList<>();

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<int []>());
        }

        for(int [] edge : times) {
            int ui = edge[0];
            int vi = edge[1];
            int ti = edge[2];

            graph.get(ui).add(new int [] {vi, ti});
        }

        distances[k] = 0;

        PriorityQueue<int []> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        pq.add(new int[] {k,0});

        boolean [] visited = new boolean[n+1];

        while(!pq.isEmpty()) {
            int [] current = pq.remove();

            int node = current[0];

            int cost = current[1];

            if(visited[node]) continue;

            visited[node] = true;

            for(int [] edge : graph.get(node)) {
                int neighbor = edge[0];
                int price = edge[1];

                if(cost + price < distances[neighbor]) {
                    distances[neighbor] = cost+price;
                    pq.add(new int[] {neighbor, distances[neighbor]});
                }
            }
        }
        int maximum = 0;

        for(int i = 1; i < distances.length; i++) {
            if(distances[i] == Integer.MAX_VALUE) return -1;
            maximum = Math.max(maximum, distances[i]);
        }

        return maximum;
    }
}
