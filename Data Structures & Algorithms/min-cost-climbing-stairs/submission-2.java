class Solution {
    /*public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        return Math.min(minCostClimbingStairsRec(cost, dp, n-1),
                minCostClimbingStairsRec(cost, dp, n-2));
    }

    private int minCostClimbingStairsRec(int[] cost, int[] dp, int index) {
        //if(index < 0) return Integer.MAX_VALUE;
        if(index == 0 || index == 1) return cost[index];
        if(dp[index] != Integer.MAX_VALUE) return dp[index];
        int oneJump = minCostClimbingStairsRec(cost, dp, index-1);
        int twoJump = minCostClimbingStairsRec(cost, dp, index - 2);
        return dp[index] = cost[index] + Math.min(oneJump, twoJump);
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i =2 ; i < n ; i++){
            int oneJump = dp[i-1];
            int twoJump = dp[i-2];
            dp[i] = cost[i] + Math.min(oneJump, twoJump);
        }
        return Math.min(dp[n-1], dp[n-2]);
    }*/

    public int minCostClimbingStairs (int[] cost) {
        int n = cost.length;
        int firstPev = cost[0];
        int secondPrev = cost[1];
        for(int i =2 ; i < n ; i++){
            int temp = cost[i] + Math.min(firstPev, secondPrev);
            firstPev = secondPrev;
            secondPrev = temp;
        }
        return Math.min(firstPev, secondPrev);
    }
}
