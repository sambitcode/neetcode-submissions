class Solution {
   /*public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        return robRec(nums, dp, 0);
    }

    private int robRec(int[] nums, int[] dp, int index) {
        if(index >= dp.length ) return 0;
        if(dp[index] != Integer.MIN_VALUE) return dp[index];
        int take = nums[index] + robRec(nums, dp,index+2);
        int notTake = robRec(nums, dp, index+1);
        return dp[index] = Math.max(take, notTake);

    }*/

    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+2];
        for(int i = n-1; i >=0; i--){
            dp[i] = Math.max(nums[i] + dp[i+2], dp[i+1]);
        }
        return dp[0];
    }

    /*public int rob(int[] nums) {
        int n = nums.length;
        int last = 0;
        int secondLast = 0;
        for(int i = n-1; i >=0; i--){
            int temp = Math.max(nums[i] + secondLast, last);
            secondLast = last;
            last = temp;
        }
        return last;
    }*/
}
