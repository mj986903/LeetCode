class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        int dp [] = new int [nums.length];
        for(int i=0;i<dp.length;i++){
            dp [i] = 1;
        }
        int maxSize = 1;
        int maxIndex = 0;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i] % nums[j] == 0){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    if(dp[i]>maxSize){
                        maxSize = dp[i];
                        maxIndex = i;
                    }
                }
            }
        }
        int num = nums[maxIndex];
        for(int i=maxIndex;i>=0;i--){
            if (num % nums[i] == 0 && dp[i] == maxSize) {
                ans.add(nums[i]);
                num = nums[i];
                maxSize--;
            }
        }
        return ans;
    }
}