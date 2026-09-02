class Solution {
    public int leastInterval(char[] tasks, int n) {
        int [] counts = new int[26];

        for(char task : tasks) {
            counts[task - 'A']++;
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)->b-a);

        for(int count : counts) {
            if(count>0) heap.add(count);
        }
        Queue<int[]> q = new LinkedList<>();
        int time = 0;

        while(!heap.isEmpty() || !q.isEmpty()) {
            time++;

            if(!heap.isEmpty()) {
                int count = heap.remove() - 1;
                if(count > 0) q.add(new int [] {count, time+n});
            }

            if(!q.isEmpty() && q.peek()[1] == time) {
                heap.add(q.remove()[0]);
            }
        }
        return time;
    }
}
