class Solution {
    private static boolean isPalindrome(String s){
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        String longestSbs = s.substring(0, 1);
        int maxLen = 1;
        int n = s.length();
        
        for(int i=0;i<n;i++){
            for(int j=i+maxLen;j<=n;j++){
                if(j-i > maxLen && isPalindrome(s.substring(i,j))){
                    maxLen = j-i;
                    longestSbs = s.substring(i,j);
                }
            }
        }
        
        return longestSbs;
    }
}