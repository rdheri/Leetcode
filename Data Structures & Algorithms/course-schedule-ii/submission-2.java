class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Prereq: [a,b] : b->a
        // numCourses, 0 to n-1
        ArrayList<Integer> course = new ArrayList<>();
        int [] indegrees = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for(int [] edge : prerequisites) {
            int a = edge[0];
            int b = edge[1];
            graph.get(b).add(a);
            indegrees[a]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegrees[i] == 0) queue.add(i);
        }
        boolean [] visited = new boolean[numCourses];
        while(!queue.isEmpty()) {
            int current = queue.remove();
            if(visited[current]) continue;
            course.add(current);
            visited[current] = true;
            for(int neighbor : graph.get(current)) {
                indegrees[neighbor]--;
                if(indegrees[neighbor] == 0) {
                    queue.add(neighbor);
            }
        }
    }
    int [] res = new int[course.size()];
    if(course.size() != numCourses) return new int[] {};
    for(int i = 0; i < course.size(); i++) {
        res[i] = course.get(i);
    }
    return res;
}
}
