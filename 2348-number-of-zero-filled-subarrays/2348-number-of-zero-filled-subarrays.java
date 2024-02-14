class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long dp [] = new long [nums.length];
        long count = 0;
        if(nums[0] == 0){
            dp[0] = 1;
        }else{
            dp[0] = 0;
        }
        for(int i=1;i<nums.length;i++){
            if(nums[i] == 0){
                dp[i] = dp[i-1] + 1;
            }else{
                dp[i] = 0;
            }
        }
        for(int j=0;j<dp.length;j++){
            count = count + dp[j];
        }
        return count;
    }
}