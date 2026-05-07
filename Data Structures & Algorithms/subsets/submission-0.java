class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subsetsRec(nums, result, 0, new ArrayList<>());
        System.out.print(result);
        return result;
    }

    private void subsetsRec(int[] nums, List<List<Integer>> result, int index, List<Integer> curr) {
        result.add(new ArrayList<>(curr));
        for(int i = index; i < nums.length; i++){
            curr.add(nums[i]);
            subsetsRec(nums, result, i+1, curr);
            curr.remove(curr.size()-1);
        }
    }
}
