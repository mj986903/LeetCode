class Solution {
    public String customSortString(String order, String s) {
        String ans = "";
        int count [] = new int[256];
        for(char c : s.toCharArray()){
            count[c-'a']++;
        }
        for(char c : order.toCharArray()){
            while(count[c-'a'] != 0){
                ans = ans + c;
                count[c-'a']--;
            }
        }
        for(char c : s.toCharArray()){
            while(count[c-'a'] != 0){
                ans = ans + c;
                count[c-'a']--;
            }
        }
        return ans;
    }
}