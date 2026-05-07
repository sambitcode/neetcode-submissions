class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int firstPointer = 0;
        int lastPointer = height.length-1;
        while(firstPointer < lastPointer){
            int heightOfFirst = height[firstPointer];
            int heightOfLast = height[lastPointer];
            int area = Math.min(heightOfFirst, heightOfLast) * (lastPointer-firstPointer);
            maxArea = Integer.max(maxArea, area);
            if(heightOfFirst < heightOfLast){
                firstPointer++;
            } else {
                lastPointer--;
            }
        }
        return maxArea;
    }
}
