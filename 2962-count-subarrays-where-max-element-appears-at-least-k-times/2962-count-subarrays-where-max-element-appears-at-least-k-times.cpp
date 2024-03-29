class Solution {
public:
    long long countSubarrays(vector<int>& nums, int k) {
        int max = INT_MIN;
        for(int n : nums){
            max = n > max ? n:max;
        }
        
        long long result = 0;
        int j = 0;
        
        for(int n : nums){
            k -= (max==n);
            while(k==0){
                k += (max==nums[j++]);
            }
            result = result + j;
        }
        return result;
    }
};