class Solution {
  public int jump(int[] nums) {
    int ans = 0;
    int end = 0;
    int temp = 0;
    for (int i=0;i<nums.length-1;i++) {
      temp = Math.max(temp, i + nums[i]);
      if (temp >= nums.length - 1) {
        ans++;
        break;
      }
      if (i == end) {
        ans++;
        end = temp;
      }
    }
    return ans;
  }
}