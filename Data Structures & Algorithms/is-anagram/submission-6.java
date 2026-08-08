class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if(!map.containsKey(c)) return false;
            int newCount = map.get(c) - 1;
            if(newCount == 0) {
                map.remove(c);
            }
            else {
                map.put(c, newCount);
            }
        }
        return map.isEmpty();
    }
}

