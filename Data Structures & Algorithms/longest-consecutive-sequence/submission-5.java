class Solution {
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int maxCount = 1;
        int count = 1;
        int current = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(current == nums[i])continue;
            if(current+1 == nums[i]){
                count++;
            } else {
                count = 1;
            }
            current = nums[i];
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }
}
