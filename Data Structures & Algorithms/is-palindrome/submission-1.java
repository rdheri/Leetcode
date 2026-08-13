class Solution {
    public boolean isPalindrome(String s) {
        s = s.trim().toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        while(left < right) {
            while(!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while(!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
            }
            return true;
        }
}
