class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // temperatures = [30,38,30,36,35,40,28]

        if(temperatures.length == 0) return new int [] {};

        int [] result = new int[temperatures.length];

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for(int i = temperatures.length - 1; i >= 0; i--) {
            int currentTemp = temperatures[i];

            if(stack.isEmpty()) {
                stack.push(i);
                result[i] = 0;
            }
            else {
                if(currentTemp < temperatures[stack.peek()]) {
                    result[i] = stack.peek() - i;
                    stack.push(i);
                }
                else {
                    while(!stack.isEmpty() && !(currentTemp < temperatures[stack.peek()])) {
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
        }  
        return result;
    }
}
