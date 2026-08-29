class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length == 0) return new int [] {};

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }  

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(entry);

            if(pq.size() > k) pq.remove();
        } 

        int [] res = new int[k];
        for(int i = 0; i < k; i++) {
            res[i] = pq.remove().getKey();
        }
        return res
    }
}
