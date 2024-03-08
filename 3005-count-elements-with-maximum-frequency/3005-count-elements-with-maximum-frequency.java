class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else{
                map.put(i,1);
            }
        }
        int maxFreq = Integer.MIN_VALUE;
        for(int i : map.keySet()){
            maxFreq = Math.max(maxFreq,map.get(i));
        }
        int ans = 0;
        for(int i : map.keySet()){
            if(maxFreq == map.get(i)){
                ans = ans + maxFreq;
            }
        }
        return ans;
    }
}