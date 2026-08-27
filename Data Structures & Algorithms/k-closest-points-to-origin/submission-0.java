class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]); // distance, x, y

        for (int[] point : points) {
            int dist = point[0] * point[0] + point[1] * point[1];
            pq.add(new int[] {dist, point[0], point[1]});
            if (pq.size() > k) {
                pq.remove();
            }
        }

        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] top = pq.remove();
            res[i][0] = top[1];
            res[i][1] = top[2];
        }

        return res;
    }
}
