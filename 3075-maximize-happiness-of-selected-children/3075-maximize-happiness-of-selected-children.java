class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int count = 0;
        long ans = 0;
        int last = happiness.length - 1;
        
        for(int i=0;i<k;i++){
            ans = ans + Math.max(0,happiness[last]-count);
            count++;
            last--;
        }
        return ans;
    }
}