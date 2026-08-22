class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // [a,b] : b -> a

        List<List<Integer>> graph = new ArrayList<>();

        int [] indegree = new int[numCourses];

        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for(int [] pre : prerequisites) {
            int a = pre[0];
            int b = pre[1];

            graph.get(b).add(a);

            indegree[a]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) queue.add(i);
        }

        int counter = 0;

        while(!queue.isEmpty()) {
            int currentNode = queue.remove();
            counter++;

            for(int neighbor : graph.get(currentNode)) {
                indegree[neighbor]--;
                if(indegree[neighbor] == 0) queue.add(neighbor);
            }
        }
        return counter == numCourses;
    }
}
