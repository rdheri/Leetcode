class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for(int stone : stones) pq.add(stone);

        while(pq.size() > 1) {
            int first = pq.remove();
            int second = pq.remove();

            if(Math.abs(first - second) == 0) continue;

            else {
                pq.add(Math.abs(first - second));
            }
        }
        if (pq.peek() == null) return 0;
        return pq.peek();
    }
}
