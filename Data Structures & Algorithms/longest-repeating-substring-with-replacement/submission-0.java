class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0;
        int max = 0;
        int res = 0;
        for(int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if(map.get(c) > max) max = map.get(c);

            while ((r - l + 1) - max > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                if(map.get(s.charAt(l)) == 0) map.remove(s.charAt(l));
                l++;
            }
            res = Math.max(res, r - l + 1);
        }   
        return res;       
    }
}
