class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // times: ui to vi, with cost ti
        // nodes are labelled 1 to n
        // directed graph
        // k: source node
        // return : maximum time taken/last node reached time

        List<List<int[]>> graph = new ArrayList<>();

        for(int i = 0; i <= n; i++) { // Skeleton Graph
            graph.add(new ArrayList<int[]>());
        }

        for(int [] edge : times) { // Graph Built
            int src = edge[0];
            int dst = edge[1];
            int cost = edge[2];
            graph.get(src).add(new int[] {dst, cost});
        }

        int [] distances = new int[n+1];
        Arrays.fill(distances, Integer.MAX_VALUE);

        distances[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        boolean [] visited = new boolean[n+1];

        pq.add(new int[] {k,0});

        while(!pq.isEmpty()) {
            int [] current = pq.remove();
            int node = current[0], cost = current[1];

            if(visited[node]) continue;

            visited[node] = true;

            for(int [] edge : graph.get(node)) {
                // [2,3];
                int neighbor = edge[0];
                int price = edge[1];

                if(cost + price < distances[neighbor]) {
                    distances[neighbor] = cost+price;
                    pq.add(new int [] {neighbor, distances[neighbor]});
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
