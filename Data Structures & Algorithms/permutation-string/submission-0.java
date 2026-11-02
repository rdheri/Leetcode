class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for(char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c,0)+1);
        }

        int left = 0; 
        int right = 0;

        for(right = 0; right < s2.length(); right++) {
            window.put(s2.charAt(right), window.getOrDefault(s2.charAt(right),0) + 1);

            if(right-left+1 > s1.length()) {
                window.put(s2.charAt(left), window.get(s2.charAt(left)) - 1);
                if(window.get(s2.charAt(left)) == 0) window.remove(s2.charAt(left));
                left++;
            }
            if(s1.length() == right - left + 1 && window.equals(map)) return true;
        }
        return false;
}
}
