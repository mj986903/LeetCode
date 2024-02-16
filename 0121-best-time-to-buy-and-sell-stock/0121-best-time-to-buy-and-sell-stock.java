class Solution {
    public int maxProfit(int[] prices) {
        int maxpro=0;
        int daypro=0;
        int minpri=prices[0];
        for(int i=0;i<prices.length;i++){
            minpri=Math.min(minpri , prices[i]);
            daypro=prices[i]-minpri;
            maxpro=Math.max(maxpro , daypro);
        }
        return maxpro;
    }
}