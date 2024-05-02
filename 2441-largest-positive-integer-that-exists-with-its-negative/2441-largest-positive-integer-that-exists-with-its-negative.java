class Solution {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length-1;
        
        while(left < right && nums[left] < 0){
            if(Math.abs(nums[left]) == nums[right]){
                return nums[right];
            }else if(Math.abs(nums[left]) < nums[right]){
                right--;
            }else{
                left++;
            }
        }
        return -1;
    }
}