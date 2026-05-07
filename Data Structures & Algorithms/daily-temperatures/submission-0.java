class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        LinkedList<int[]> stack = new LinkedList<>();
        for(int i = 0; i < n; i++){
            int currTemp = temperatures[i];

            while(!stack.isEmpty() && stack.peek()[1] < currTemp){
                int[] prev = stack.pop();
                result[prev[0]] = i - prev[0];
            }

            stack.push(new int[]{i, currTemp});
        }
        return result;
    }
}
