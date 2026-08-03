class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        Set<Map.Entry<Integer, Integer>> entry = map.entrySet();
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(entry);

        entries.sort((a, b) -> b.getValue() - a.getValue());

        int[] topK = new int[k];
        for (int i = 0; i < k; i++) {
            topK[i] = entries.get(i).getKey();
        }

        return topK;
    }
}
