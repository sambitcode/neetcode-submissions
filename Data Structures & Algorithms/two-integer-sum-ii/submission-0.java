class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int firstP = 0;
        int lastP = numbers.length-1;
        while(firstP<lastP){
            if(numbers[firstP] + numbers[lastP] == target){
                return new int[]{firstP+1, lastP+1};
            } else if(numbers[firstP] + numbers[lastP] > target){
                lastP--;
            } else {
                firstP++;
            }
        }
        return new int[]{};
    }
}
