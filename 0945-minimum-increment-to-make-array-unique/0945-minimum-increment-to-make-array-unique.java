class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int nxt = nums[0] + 1;
        for (int i = 1; i < nums.length; i++) {
            if (nxt >= nums[i]) {
                ans = ans + (nxt - nums[i]);
                nxt++;
            } else {
                nxt = nums[i] + 1;
            }
        }
        return ans;
    }
}