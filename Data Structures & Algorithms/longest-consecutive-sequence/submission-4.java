class Solution {
    public int longestConsecutive(int[] nums) {
        int longest = 0;
        for (int num : nums) {
            int x = num;
            int count = 1;
            while (linearSearch(nums, x + 1)) {
                x = x + 1;
                count++;
            }
            longest = Math.max(longest, count);
        }
        return longest;
    }

    public boolean linearSearch(int[] nums, int target) {
        for (int num : nums) {
            if (num == target)
                return true;
        }
        return false;
    }
}
