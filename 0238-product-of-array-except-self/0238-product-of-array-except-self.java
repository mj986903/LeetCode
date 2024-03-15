class Solution {
    public int[] productExceptSelf(int[] nums) {
        int answer [] = new int[nums.length];
        for(int i=0;i<answer.length;i++){
            answer[i] = 1;
        }
        int temp = 1;
        for(int i=0;i<nums.length;i++){
            answer[i] = answer[i] * temp;
            temp = temp * nums[i];
        }
        temp = 1;
        for(int j=nums.length-1;j>=0;j--){
            answer[j] = answer[j] * temp;
            temp = temp * nums[j];
        }
        return answer;
    }
}