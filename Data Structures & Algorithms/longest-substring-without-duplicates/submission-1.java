class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxL = 0;
        int left = 0;
        int right = 0;
        for(right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);

            while(map.get(c) > 1) {
                char leftC = s.charAt(left);;
                map.put(leftC, map.get(leftC) - 1);

                if(map.get(leftC) == 0) map.remove(leftC);

                left++;
            }
            maxL = Math.max(maxL, right - left + 1);
        }  
        return maxL; 
    }
}
