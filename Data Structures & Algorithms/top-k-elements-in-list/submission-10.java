class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num,0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            heap.add(entry);

            while(heap.size() > k) {
                heap.remove();
            }
        }
        int[] res = new int[k];

        for(int i = 0; i < k; i++) {
            res[i] = heap.remove().getKey();
        }

        return res;
    }
}
