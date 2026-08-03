class Solution {
    public boolean isAnagram(String s, String t) {
        s = s.toLowerCase();
        t = t.toLowerCase();
        if(s.length() != t.length()) return false;

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        HashMap<Character, Integer> secondMap = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            secondMap.put(t.charAt(i), secondMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        return (map.equals(secondMap));
    }
}
