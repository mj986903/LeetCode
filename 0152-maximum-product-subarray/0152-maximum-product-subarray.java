class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int ans = nums[0];
        
        for(int i=1;i<nums.length;i++){
            int temp = min;
            min = Math.min(nums[i],Math.min(nums[i]*max,nums[i]*min));
            max = Math.max(nums[i],Math.max(nums[i]*max,nums[i]*temp));
            ans = Math.max(ans,max);
        }
        return ans;
    }
}