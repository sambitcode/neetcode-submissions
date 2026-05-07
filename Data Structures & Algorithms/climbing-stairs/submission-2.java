class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        return climbStairsRec(n, dp);
    }

    private int climbStairsRec(int n, int[] dp) {
        if(n==0) return 1;
        if(dp[n] != 0) return dp[n];
        int twoCount = 0;
        if(n >= 2){
            twoCount = climbStairsRec(n-2, dp);
        }
        int oneCount = climbStairsRec(n-1, dp);
        return dp[n] = oneCount + twoCount;
    }
}
