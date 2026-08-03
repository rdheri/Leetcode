class Solution {
    public boolean isAnagram(String s, String t) {
        if(!(s.length() == t.length())) {
            return false;
        }
        HashMap<Character, Integer> mapS = new HashMap<Character, Integer>();
        HashMap<Character, Integer> mapT = new HashMap<Character, Integer>();

        for(int i = 0; i < s.length(); i++) {
            mapS.put(s.charAt(i), mapS.getOrDefault(s.charAt(i), 0) + 1);
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }
        if(mapS.equals(mapT)) return true;
        return false;
    }
}
