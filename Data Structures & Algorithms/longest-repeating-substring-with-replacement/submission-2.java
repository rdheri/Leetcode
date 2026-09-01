class Solution {
    public int characterReplacement(String s, int k) {
        // s = XYYXX, k = 2

        if(s.length() == 0) return 0;

        int maxF = 0, left = 0, right = 0, maxL = 0;
        // 4 - 3 = 1

        //Character that needs to be replaced = window length - maxFrequency

        HashMap<Character, Integer> map = new HashMap<>();

        for(right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1); // X:1, Y:2, 

            maxF = Math.max(map.get(c), maxF); // 1

            while(right - left + 1 - maxF > k) {
                char cLeft = s.charAt(left);
                map.put(cLeft, map.get(cLeft) - 1);
                if(map.get(cLeft) == 0) map.remove(cLeft);
                left++;
            }

            maxL = Math.max(maxL, right - left + 1);
        }

        return maxL;

    }
}
