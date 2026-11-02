class Solution {
    public int lengthOfLongestSubstring(String s) {
        // zxyzxyz
        if(s.length() == 0) return 0;

        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;
        int max = 0;

        for(right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            map.put(c, map.getOrDefault(c, 0) + 1);

            while(map.get(c) > 1) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                if(map.get(s.charAt(left)) == 0) map.remove(s.charAt(left));
                left++;
            }
            max = Math.max(right - left + 1, max);
        }
        return max;
    }
}
