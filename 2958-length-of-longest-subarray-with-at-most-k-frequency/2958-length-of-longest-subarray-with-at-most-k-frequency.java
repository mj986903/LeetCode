class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int left = 0;
        int length = Integer.MIN_VALUE;
        
        for(int right=0;right<nums.length;right++){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            while(map.get(nums[right]) > k){
                map.put(nums[left],map.get(nums[left])-1);
                left++;
            }
            length = Math.max(length,right-left+1);
        }
        return length;
    }
}