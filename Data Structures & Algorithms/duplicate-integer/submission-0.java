class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Boolean> myMap = new HashMap<>();
        for(int i : nums){
            if(myMap.containsKey(i)) return true;
            myMap.put(i, true);
        }
        return false;
    }
}