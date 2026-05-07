class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        calCombinationSumII(candidates, target, 0, result, new ArrayList<>());
        return result;
    }

    private void calCombinationSumII(int[] candidates, int target, int index, List<List<Integer>> result, List<Integer> curr) {
        if(target == 0){
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i = index; i < candidates.length; i++){
            if(i> index && candidates[i] == candidates[i-1]) continue;
            if(candidates[i] > target) break;
            curr.add(candidates[i]);
            calCombinationSumII(candidates, target-candidates[i], i+1, result, curr);
            curr.remove(curr.size()-1);
        }
    }
}
