class Solution {
   public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        for(int i : stones){
            pq.offer(i);
        }
        while(!pq.isEmpty()){
            if(pq.size()==1) return pq.poll();
            int first = pq.poll();
            int second = pq.poll();
            if(first > second) {
                pq.offer(first - second);
            }
        }
        return 0;
    }
}
