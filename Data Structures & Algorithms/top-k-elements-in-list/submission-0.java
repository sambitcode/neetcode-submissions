class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> pQueue = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1])); //min heap less frequent are at top
        Map<Integer, Integer> myMap = new HashMap<>();
        for(int i = 0 ; i < nums.length; i++){
            myMap.put(nums[i], myMap.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer, Integer> entrySet : myMap.entrySet()){
            pQueue.offer(new int[]{entrySet.getKey(), entrySet.getValue()});
            if(pQueue.size() > k){ //size three makes sure 3rd position 3rd frequent
                pQueue.poll();
            }
        }
        // Collect top k
        int[] result = new int[k];
        int i = 0;
        while(!pQueue.isEmpty()){
            result[i++] = pQueue.poll()[0];
        }
        return result;
    }
}
