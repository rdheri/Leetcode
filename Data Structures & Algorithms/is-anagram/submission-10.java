class Solution {
    public boolean isAnagram(String s, String t) {
        // act, cat
        // 1) The same length
        // 2) The same frequency of characters

        // Edge Case: Input Strings are Empty
        // Edge Case: Input String Lengths are Different

        if(s.length() == 0 && t.length() == 0) return false;
        if(s.length() != t.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Map: {a, 1}, {c, 1}, {t, 1}

        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);

            if(map.containsKey(c)) {
                map.put(c, map.get(c) - 1);

                if(map.get(c) == 0) {
                    map.remove(c);
                }
            }
        }

        return map.isEmpty();
    }
}
