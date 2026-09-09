class Solution {
    public int leastInterval(char[] tasks, int n) {
        int [] counts = new int[26];
        for(char task : tasks) {
            counts[task - 'A']++;
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> b - a);

        for(int count : counts) {
            if(count > 0) heap.add(count);
        }

        int time = 0;
        
        Queue<int []> queue = new LinkedList<>();

        while(!heap.isEmpty() || !queue.isEmpty()) {
            time++;

            if(!heap.isEmpty()) {
                int count = heap.remove() - 1;
                if(count > 0) {
                    int coolDown = time + n;
                    queue.add(new int [] {count, coolDown});
                }
            }

            if(!queue.isEmpty() && queue.peek()[1] == time) {
                heap.add(queue.remove()[0]);
            }
        }
        return time;
    }
}
