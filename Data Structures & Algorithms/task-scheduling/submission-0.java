class Solution {
    public int leastInterval(char[] tasks, int n) {
        int [] counts = new int[26];

        for(char task : tasks) {
            counts[task - 'A']++; 
        }

        PriorityQueue<Integer> maxheap = new PriorityQueue<>((a,b) -> b - a);

        for(int count : counts) {
            if(count > 0) maxheap.add(count);
        }

        Queue<int[]> queue = new LinkedList<>();

        int time = 0;

        while(!queue.isEmpty() || !maxheap.isEmpty()) {
            time++;

            if(!maxheap.isEmpty()) {
                int count = maxheap.remove() - 1;
                if(count > 0) {
                    queue.add(new int [] {count, time + n});
                }
            }
            if(!queue.isEmpty() && queue.peek()[1] == time) {
                maxheap.add(queue.remove()[0]);
            }
        }
        return time;
    }
}
