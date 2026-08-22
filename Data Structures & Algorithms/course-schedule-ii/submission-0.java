class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // [a,b] : b is a prereq for a : b -> a

        // courses : 0 to n - 1

        int[] indegree = new int[numCourses];

        List<List<Integer>> graph = new ArrayList<>();

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for(int [] pre : prerequisites) {
            int a = pre[0];
            int b = pre[1];

            graph.get(b).add(a);

            indegree[a]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {
            int currentNode = queue.remove();
            list.add(currentNode);

            for(int neighbors : graph.get(currentNode)) {
                indegree[neighbors]--;
                if(indegree[neighbors] == 0) queue.add(neighbors);
            }
        }
        if (list.size() != numCourses) return new int[] {};
        int[] res = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
