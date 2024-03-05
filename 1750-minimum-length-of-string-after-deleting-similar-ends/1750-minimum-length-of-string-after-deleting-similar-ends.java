class Solution {
    public int minimumLength(String s) {
        int left = 0;
        int right = s.length()-1;
        while(left<right && s.charAt(left) == s.charAt(right)){
            char curr = s.charAt(left);
            while(left < s.length() && s.charAt(left) == curr){
                left++;
            }
            while(right>=0 && s.charAt(right) == curr){
                right--;
            }
        }
        if(right < left){
            return 0;
        }
        return right-left+1;
    }
}