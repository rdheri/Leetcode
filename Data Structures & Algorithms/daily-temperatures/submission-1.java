class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures.length == 0) return new int[] {};

        // [30,38,30,36,35,40,28]

        int n = temperatures.length;

        int[] res = new int[n];

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for(int i = n-1; i >= 0; i--) {
            if(stack.isEmpty()) {
                res[i] = 0;
                stack.push(i);
            }
            else {
                if(temperatures[i] < temperatures[stack.peek()]) {
                    res[i] = stack.peek() - i;
                    stack.push(i);
                }
                else {
                    while(!stack.isEmpty() && !(temperatures[i] < temperatures[stack.peek()])) {
                        stack.pop();
                    }
                    if(stack.isEmpty()) {
                        res[i] = 0;
                        stack.push(i);
                    }
                    else {
                        res[i] = stack.peek() - i;
                        stack.push(i);
                    }
                }
            }
        }
        return res;
    }
}
