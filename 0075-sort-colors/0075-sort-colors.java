class Solution {
    public void sortColors(int[] nums) {
        int count [] = new int[3];
        for(int i=0;i<nums.length;i++){
            count[nums[i]]++;
        }
        for(int i=1;i<count.length;i++){
            count[i] = count[i] + count[i-1];
        }
        int sortNums [] = new int[nums.length];
        for(int i=nums.length-1;i>=0;i--){
            sortNums[count[nums[i]]-1] = nums[i];
            count[nums[i]]--;
        }
        for(int i=0;i<nums.length;i++){
            nums[i] = sortNums[i];
        }
    }
}