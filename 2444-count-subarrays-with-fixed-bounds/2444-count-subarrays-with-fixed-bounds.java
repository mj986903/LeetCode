class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0;
        int minIdx = -1;
        int maxIdx = -1;
        int left = 0;
        int right = 0;
        
        while(right < nums.length){
            if(nums[right]<minK || nums[right]>maxK){
                left = right+1;
            }else{
                if(nums[right] == minK){
                    minIdx = right;
                }
                if(nums[right] == maxK){
                    maxIdx = right;
                }
                ans = ans + Math.max((Math.min(minIdx, maxIdx)-left+1),0);
            }
            right++;
        }
        return ans;
    }
}