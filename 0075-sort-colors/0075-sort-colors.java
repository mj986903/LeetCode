class Solution {
    public void sortColors(int[] nums) {
        int countColor [] = new int [3];
        int sortNums [] = new int [nums.length];
        for(int i=0;i<nums.length;i++){
            countColor[nums[i]]++;
        }
        for(int j=1;j<countColor.length;j++){
            countColor[j] = countColor[j] + countColor[j-1];
        }
        for(int i=nums.length-1;i>=0;i--){
            sortNums[countColor[nums[i]]-1] = nums[i];
            countColor[nums[i]]--;
        }
        for(int i=0;i<nums.length;i++){
            nums[i] = sortNums[i];
        }
    }
}