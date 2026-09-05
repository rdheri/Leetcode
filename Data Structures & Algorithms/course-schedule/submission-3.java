class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // [a,b] : b -> a

        // 0 to numCourses - 1;

        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }

        int[] indegrees = new int[numCourses];

        for(int [] edge : prerequisites) {
            int a = edge[0];
            int b = edge[1];
            graph.get(b).add(a);
            indegrees[a]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        boolean[] visited = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++) {
            if(indegrees[i] == 0) queue.add(i);
        }

        while(!queue.isEmpty()) {
            int currentNode = queue.remove();

            if(visited[currentNode]) continue;            
            
            visited[currentNode] = true;

            for(int neighbor : graph.get(currentNode)) {
                indegrees[neighbor]--;
                if(indegrees[neighbor] == 0) queue.add(neighbor);
            }
        }
        for(boolean result : visited) {
            if(!result) return false;
        }
        return true;
    }
}
