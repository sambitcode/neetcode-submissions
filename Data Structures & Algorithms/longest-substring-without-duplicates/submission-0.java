class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n<=1) return n;
        int max = Integer.MIN_VALUE;
        int firstPointer = 0;
        int lastPointer = 1;
        Map<Character, Integer> myMap = new HashMap<>();
        char[] chars = s.toCharArray();
        myMap.put(chars[0], 0);
        while(lastPointer < n){
            if(myMap.containsKey(chars[lastPointer])){
                firstPointer = Math.max(firstPointer, myMap.get(chars[lastPointer])+1);
            }
            max = Math.max(max, lastPointer-firstPointer + 1);
            myMap.put(chars[lastPointer], lastPointer);
            lastPointer++;

        }
        return max;
    }
}
