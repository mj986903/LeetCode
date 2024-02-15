class Solution {
    public long largestPerimeter(int[] nums) {
        if(nums.length<3){
            return -1;
        }
        Arrays.sort(nums);
        long currSum = 0;
        long periSum = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] < currSum){
                periSum = currSum + nums[i];
            }
            currSum = currSum + nums[i];
        }
        if(periSum == 0){
            return -1;
        }
        return periSum;
    }
}