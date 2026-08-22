class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // b is a prereq for a : b -> a

        List<List<Integer>> graph = new ArrayList<>(); // [[0,1], [2,1].......]

        int [] inDegree = new int[numCourses];

        for(int i = 0; i < numCourses; i++) { // this builds a skeleton graph
            graph.add(new ArrayList<Integer>());
        }

        for(int [] edge : prerequisites) { // builds my incoming edges array
            int u = edge[0]; // this is vertex a
            int v = edge[1]; // this is vertex b
            graph.get(v).add(u); // adding the edge b->a
            inDegree[edge[0]]++; // increase the incoming edge counter for a 
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0) queue.add(i);
        }

        int counter = 0;

        while(!queue.isEmpty()) {
            int currentNode = queue.remove();
            counter++;

            for(int neighbor : graph.get(currentNode)) {
                inDegree[neighbor]--;

                if(inDegree[neighbor] == 0) queue.add(neighbor);
            }
        }

        return counter == numCourses;

    }
}
