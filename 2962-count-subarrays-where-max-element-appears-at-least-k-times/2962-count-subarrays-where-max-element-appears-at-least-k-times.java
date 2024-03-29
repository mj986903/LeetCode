class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxElement = nums[0];
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(nums[0],1);
        
        for(int i=1;i<nums.length;i++){
            if(maxElement < nums[i]){
                maxElement = nums[i];
            }
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        
        int left = 0;
        int right = 0;
        int count = 0;
        long ans = 0;
        
        while(right < nums.length){
            if(nums[right] == maxElement){
                count++;
                if(count >= k && count <= map.get(maxElement)){
                    int temp = count;
                    while(temp >= k){
                        if(nums[left] == maxElement){
                            temp--;
                        }
                        ans = ans + nums.length - right;
                        left++;
                    }
                    count = temp;
                }
            }
            right++;
        }
        
        return ans;
    }
}