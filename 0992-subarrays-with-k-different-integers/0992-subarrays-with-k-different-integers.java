class Solution {
    public static int subarraysWithAtMostKDistinct(int[] nums,int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        int left = 0;
        int right =0;
        int ans = 0;
        
        while(right < nums.length){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            while(map.size() > k){
                map.put(nums[left],map.get(nums[left])-1);
                if(map.get(nums[left]) == 0){
                    map.remove(nums[left]);
                }
                left++;
            }
            ans = ans + right - left + 1;
            right++;
        }
        return ans;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        int subarrayWithMaximumK = subarraysWithAtMostKDistinct(nums,k);
        int reducedSubarrayWithMaximumK = subarraysWithAtMostKDistinct(nums,k-1);
        
        return subarrayWithMaximumK - reducedSubarrayWithMaximumK;
    }
}