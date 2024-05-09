class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int count = 0;
        long ans = 0;
        int last = happiness.length - 1;
        
        for(int i=0;i<k;i++){
            int temp = happiness[last]-count;
            if(temp > 0){
                ans = ans + temp;
            }
            count++;
            last--;
        }
        return ans;
    }
}