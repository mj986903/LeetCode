class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> numsIndex = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int compliment = target-nums[i];
            if(numsIndex.containsKey(compliment)){
                return new int [] {numsIndex.get(compliment),i};
            }
            numsIndex.put(nums[i],i);
        }
        return new int[0];
    }
}