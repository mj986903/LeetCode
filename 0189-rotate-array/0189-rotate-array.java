class Solution {
    public void rotate(int[] nums, int k) {
        Queue<Integer> q = new LinkedList<>();
        k = k % nums.length;
        for(int i=nums.length-k;i<nums.length;i++){
            q.offer(nums[i]);
        }
        for(int i=0;i<nums.length-k;i++){
            q.offer(nums[i]);
        }
        for(int i=0;i<nums.length;i++){
            nums[i] = q.poll();
        }
    }
}