class Solution {
    private static boolean good(String s){
        char [] arr = s.toCharArray();
        Arrays.sort(arr);
        for(int i=0;i<arr.length-1;i++){
            if(arr[i] == arr[i+1]){
                return false;
            }
        }
        return true;
    }
    public int countGoodSubstrings(String s) {
        int count = 0;
        for(int i=0;i<s.length()-2;i++){
            String str = s.substring(i,i+3);
            if(good(str)){
                count++;
            }
        }
        return count;
    }
}