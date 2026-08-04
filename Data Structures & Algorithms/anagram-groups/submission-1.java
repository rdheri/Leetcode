class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            String originalWord = strs[i];
            char [] c = originalWord.toCharArray();
            Arrays.sort(c);
            String sortedWord = new String(c);

            map.putIfAbsent(sortedWord, new ArrayList<String>());
            map.get(sortedWord).add(originalWord);
        }

        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
            res.add(entry.getValue());
        } 
        return res;    
    }
}
