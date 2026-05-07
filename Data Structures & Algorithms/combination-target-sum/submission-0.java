class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        combinationSumRec(nums, target, result, curr, 0);
        return result;
    }

    private void combinationSumRec(int[] nums, int target, List<List<Integer>> result, List<Integer> curr, int index) {
        if(target == 0){
            result.add(new ArrayList<>(curr));
        }
        if(target < 0) return;
        for (int i = index; i < nums.length; i++) {
            curr.add(nums[i]);
            combinationSumRec(nums, target - nums[i], result, curr, i);
            curr.remove(curr.size() - 1);
        }
    }
}
