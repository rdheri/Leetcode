class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // 30,38,30,36,35,40,28

        if(temperatures.length == 0) return new int[] {};

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int[] result = new int[temperatures.length];

        for(int i = temperatures.length - 1; i >= 0; i--) {
            if(stack.isEmpty()) {
                result[i] = 0;
                stack.push(i);
            }
            else if(temperatures[i] < temperatures[stack.peek()]) {
                result[i] = stack.peek() - i;
                stack.push(i);
            }
            else {
                while(!stack.isEmpty() && !(temperatures[i] < temperatures[stack.peek()])) {
                    stack.pop();
                }
                if(stack.isEmpty()) {
                    result[i] = 0;
                    stack.push(i);
                }
                else {
                    result[i] = stack.peek() - i;
                    stack.push(i);
                }
            }
        } 
        return result;
    }
}
