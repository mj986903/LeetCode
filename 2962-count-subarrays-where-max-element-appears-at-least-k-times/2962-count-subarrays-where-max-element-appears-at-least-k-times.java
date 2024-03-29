class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxElement = Integer.MIN_VALUE;
        for(int n : nums){
            maxElement = Math.max(maxElement,n);
        }
        
        int left = 0;
        int right = 0;
        int count = 0;
        long ans = 0;
        
        while(right < nums.length || left > right){
            if(nums[right] == maxElement){
                count++;
            }
            while(count >= k){
                if(nums[left] == maxElement){
                    count--;
                }
                ans = ans + nums.length - right;
                left++;
            }
            right++;
        }
        return ans;
    }
}