class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);

        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);

        for(int i = 2; i < nums.length -1; i++){
            int notRob = prev1;
            int rob = nums[i] + prev2;
            int max = Math.max(notRob, rob);
            prev2 = prev1;
            prev1 = max;
        }
        int robHouseZero = prev1;
        prev2 = nums[1];
        prev1 = Math.max(nums[1], nums[2]);
        for(int i = 3; i < nums.length; i++){
            int notRob = prev1;
            int rob = nums[i] + prev2;
            int max = Math.max(notRob, rob);
            prev2 = prev1;
            prev1 = max;
        }
        int robLastHouse = prev1;
        return Math.max(robHouseZero, robLastHouse);
    }
}
