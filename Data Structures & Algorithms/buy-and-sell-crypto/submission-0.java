class Solution {
    public int maxProfit(int[] prices) {
        int low = prices[0];
        int high = prices[0];
        int profit = 0;
        for(int i =1; i <prices.length; i++){
            if(prices[i] < low){
                low = prices[i];
                high = prices[i];
            } else if(prices[i]>high){
                high = prices[i];
                profit = Math.max(profit, high - low);
            }

        }
        return profit;
    }

    public int maxProfitBetter(int[] prices) {
        int min = prices[0];
        int profit = 0;
        for( int  i = 1; i < prices.length; i++){
            min = Math.min(min, prices[i]);
            profit = Math.max(profit, prices[i]-min);
        }
        return profit;
    }
}
