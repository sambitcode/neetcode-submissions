class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        int maxCount = 1;
        for( int i = 0 ; i < nums.length; i++){
            int latest = nums[i];
            int count = 1;
            for(int j = 0; j< nums.length;){
                //if(i==j) continue;
                if(nums[j] == latest+1){
                    latest = nums[j];
                    count++;
                    j=0;
                } else {
                    j++;
                }
            }
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }
}
