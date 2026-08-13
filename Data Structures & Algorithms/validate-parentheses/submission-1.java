class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[',']');
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            }
            else {
                if(s.charAt(i) == map.get(stack.peek())) {
                    stack.pop();
                }
                else return false;
            }
        }
        return stack.isEmpty();
    }
}
