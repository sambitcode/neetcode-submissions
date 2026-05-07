class Solution {
    /*public int[] topKFrequent(int[] nums, int k) {
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
    }*/

    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] bucketListOfArr = new List[nums.length+1];
        Map<Integer, Integer> myMap = new HashMap<>();
        for (int num : nums) {
            myMap.put(num, myMap.getOrDefault(num, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entrySet : myMap.entrySet()){
            int count = entrySet.getValue();
            if(bucketListOfArr[count] == null) {
                bucketListOfArr[count] = new ArrayList<>();
            }
            bucketListOfArr[count].add(entrySet.getKey());
        }
        // Collect top k
        int[] result = new int[k];
        int j = 0;
        for(int i = nums.length; i >=1 && j<k; i--){
            List<Integer> elements = bucketListOfArr[i];
            if(elements != null) {
                for (Integer element : elements) {
                    if (j < k) {
                        result[j++] = element;
                    } else {
                        break;
                    }
                }
            }
        }
        return result;
    }
}
