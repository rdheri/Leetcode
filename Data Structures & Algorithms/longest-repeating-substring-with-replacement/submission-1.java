class Solution {
    public int characterReplacement(String s, int k) {
        // XYYX, K = 2
        // Window Length = right - left + 1
        // Characters that need to be replaced = Window Length - Max Frequency

        HashMap<Character, Integer> map = new HashMap<>();
        int right = 0;
        int left = 0;
        int maxf = 0;
        int res = 0;
        for(right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if(map.get(c) > maxf) maxf = map.get(c);

            while(right - left + 1 - maxf > k) {
                char cLeft = s.charAt(left);
                map.put(cLeft, map.get(cLeft) - 1);
                if(map.get(cLeft) == 0) map.remove(cLeft);

                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
