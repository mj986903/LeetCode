class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
        int currSum = numbers[left] + numbers[right];
        while (currSum != target) {
            if (currSum > target) {
                right--;
            } else {
                left++;
            }
            currSum = numbers[left] + numbers[right];
        }
        return new int[] {++left, ++right};
    }
}