class Solution {
    public int hIndex(int[] citations) {
        int n=citations.length;
        int [] freq=new int[n+1];
        for(int i: citations){
            if(i>n){
                freq[n]++;
            }else{
                freq[i]++;
            }
        }
        int cnt=0;
        for(int i=n;i>=0;i--){
            cnt+=freq[i];
            if(cnt>=i){
                return i;
            }
        }
        return 0;
    }
}