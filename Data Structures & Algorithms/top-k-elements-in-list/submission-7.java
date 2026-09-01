class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // [1,2,4,5,5,5,6,6,6,6,6,7,7], k = 2

        if(nums.length == 0) return new int [] {};

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            minHeap.add(entry);
            if(minHeap.size() > k) {
                minHeap.remove();
            }
        }

        int [] res = new int[k];

        for(int i = 0; i < k; i++) {
            res[i] = minHeap.remove().getKey();
        }

        return res;
    }
}
