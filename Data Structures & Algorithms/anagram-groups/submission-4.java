class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // ["act","pots","tops","cat","stop","hat"]

        HashMap<String, List<String>> map = new HashMap<>();

        for(int i = 0; i < strs.length; i++) {
            String originalWord = strs[i];
            char [] c = originalWord.toCharArray();
            Arrays.sort(c);
            String newWord = new String(c);
            if(!map.containsKey(newWord)) {
                map.put(newWord, new ArrayList<>());
            }
            map.get(newWord).add(originalWord);
        }

        List<List<String>> res = new ArrayList<>();

        for(List<String> list : map.values()) {
            res.add(list);
        }

        return res;  
    }
}
