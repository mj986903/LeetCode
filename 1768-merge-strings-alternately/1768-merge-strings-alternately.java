class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int m = word1.length()-1;
        int n = word2.length()-1;
        int i=0,j=0;
        while(i<=m && j<=n){
            sb.append(word1.charAt(i++));
            sb.append(word2.charAt(j++));
        }
        while(i<=m){
            sb.append(word1.charAt(i++));
        }
        while(j<=n){
            sb.append(word2.charAt(j++));
        }
        return sb.toString();
    }
}