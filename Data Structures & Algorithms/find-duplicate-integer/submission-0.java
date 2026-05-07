class Solution {
    public int findDuplicate(int[] nums) {
        for(int i : nums){
        int nextIdx = Math.abs(i);
        if(nums[nextIdx] < 0) return nextIdx;
        nums[nextIdx] = - nums[nextIdx];
        }
        return -1;
    }
}
