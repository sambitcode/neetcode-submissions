class Solution {
    /*public int climbStairs(int n) {
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
    }*/

    /*public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i = 1; i <= n; i++){
            int twoCount = 0;
            if(i >= 2){
                twoCount = dp[i-2];
            }
            int oneCount = dp[i-1];
            dp[i] = oneCount + twoCount;
        }
        return dp[n];
    }

    public int climbStairs(int n) {
        //int[] dp = new int[n+1];
        int prev2 = 0;
        int prev1 = 1;
        for(int i = 1; i <= n; i++){
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }*/

    public int climbStairs(int n) { // space O(1) //time O(n)
        //int[] dp = new int[n+1];
        //Arrays.fill(dp, -1);
        int secondPrev = 1;
        int prev = 1;
        for(int i = 2 ; i <=n ; i++){
            int temp = secondPrev + prev;
            secondPrev = prev;
            prev = temp;
        }
        return prev;
    }
}
