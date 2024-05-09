class Solution {
    public int maximumCandies(int[] candies, long k) {
        Arrays.sort(candies);
        int start = 0;
        int end = candies[candies.length-1];
        
        while(start < end){
            long sum = 0;
            int mid = (start+end+1)/2;
            for(int candie : candies){
                sum = sum + candie/mid;
            }
            if(k > sum){
                end = mid-1;
            }else{
                start = mid;
            }
        }
        return start;
    }
}