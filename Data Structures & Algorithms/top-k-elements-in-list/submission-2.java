class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort((a , b) -> b.getValue() - a.getValue());

        int[] res = new int[k];

        for(int i = 0; i < res.length; i++) {
            res[i] = entries.get(i).getKey();
        }

        return res;

    }
}
