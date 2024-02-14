class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 1;
        int duplicate = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i] == nums[i-1]){
                duplicate++;
            }else{
                duplicate = 1;
            }
            if(duplicate<3){
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}