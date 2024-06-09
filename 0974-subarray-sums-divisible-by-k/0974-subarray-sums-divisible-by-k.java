class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int prefixSum = 0;
        int count = 0;
        
        for(int i=0;i<nums.length;i++){
            prefixSum = prefixSum + nums[i];
            int rem = prefixSum % k;
            if(rem < 0){
                rem = rem + k;
            }
            if(map.containsKey(rem)){
                count = count + map.get(rem);
                map.put(rem,map.get(rem)+1);
            }else{
                map.put(rem,1);
            }
        }
        return count;
    }
}