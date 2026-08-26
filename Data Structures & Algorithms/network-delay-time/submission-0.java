class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int [] distances = new int[n+1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[k] = 0;

        List<List<int[]>> graph = new ArrayList<>(); // Skeleton Graph
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        // times: ui -> vi, ti : cost of that path

        for(int [] edge : times) { // Populating the graph, [1,2]
            int source = edge[0];
            int target = edge[1];
            int cost = edge[2];
            graph.get(source).add(new int[] {target, cost});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        boolean[] visited = new boolean[n+1];

        pq.add(new int[] {k, 0});

        while(!pq.isEmpty()) {
            int [] current = pq.poll();
            int node = current[0];
            int dist = current[1];

            if(visited[node]) continue;

            visited[node] = true;

            for(int [] edge : graph.get(node)) {
                // [1, 2] : 1 is the node and 2 is the distance/weight

                int neighbor = edge[0];

                int weight = edge[1];

                if(dist + weight < distances[neighbor]) {
                    distances[neighbor] = dist + weight;
                    pq.add(new int[] {neighbor, distances[neighbor]});
                }
            }
        }
        int maximum = 0;

        for(int i = 1; i <= n; i++) {
            if(distances[i] == Integer.MAX_VALUE) return -1;
            maximum = Math.max(maximum, distances[i]);
        }
        return maximum;
    }
}
