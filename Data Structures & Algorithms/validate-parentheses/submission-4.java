class Solution {
    public boolean isValid(String s) {

        // "([{}])"

        if(s.length() == 0) return true;

        Stack<Character> stack = new Stack<>();

        HashMap<Character, Character> map = new HashMap<>();

        map.put('(', ')');
        map.put('{','}');
        map.put('[',']');

        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) stack.push(s.charAt(i));

            else if(map.containsValue(s.charAt(i))) {
                if(!stack.isEmpty() && map.get(stack.peek()) == s.charAt(i)) stack.pop();
                else return false;
            }
        }
        return stack.isEmpty();
    }
}
