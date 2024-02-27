class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reverse = "";
        for(int i=s.length()-1;i>=0;i--){
            reverse = reverse + s.charAt(i);
        }
        for(int j=0;j<s.length()-1;j++){
            if(s.charAt(j) != reverse.charAt(j)){
                return false;
            }
        }
        return true;
    }
}