class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            
            while(map.get(c) > 1) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                if(map.get(s.charAt(left)) == 0) {
                    map.remove(s.charAt(left));
                }
                left++;
            }
            ans = Math.max(ans, map.size());
        }
        return ans;
    }
}
