class Solution {
    public int characterReplacement(String s, int k) {
        if(s.length() == 0) return 0;

        //s = "AAABABB" : Characters to be replaced = window length - maximum frequency character

        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;
        int maxf = 0;

        int maxLength = 0;

        for(right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);

            maxf = Math.max(maxf, map.get(c));

            while(right - left + 1 - maxf > k) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                if(map.get(s.charAt(left)) == 0) map.remove(s.charAt(left));
                left++;
            }
            maxLength = Math.max(right-left+1, maxLength);
        }
        return maxLength;
    }
}
