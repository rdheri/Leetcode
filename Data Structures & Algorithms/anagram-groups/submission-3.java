class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // input: ["pot", "top", "cat" , "bat", "tac", "pots", "stop"]
        // output: [["pot", "top"], ["cat", "tac"].....]

        HashMap<String, List<String>> map = new HashMap<>();

        List<List<String>> res = new ArrayList<>();

        for(int i = 0; i < strs.length; i++) {
            String originalWord = strs[i];
            char [] c = originalWord.toCharArray();
            Arrays.sort(c);
            String sortedWord = new String(c);

            if(!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<String>());
        }
        map.get(sortedWord).add(originalWord);
    }
    for(List<String> list : map.values()) {
        res.add(list);
    }
    return res;
    }
}
