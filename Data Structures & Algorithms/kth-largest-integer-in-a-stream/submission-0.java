class KthLargest {
    PriorityQueue<Integer> pq;
    int k;


    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<Integer>();

        for(int num : nums) {
            pq.add(num);
            if(pq.size() > k) pq.remove();
        }
    }
    
    public int add(int val) {
        pq.add(val);

        if(pq.size() > k) pq.remove();  

        return pq.peek();
    }
}
