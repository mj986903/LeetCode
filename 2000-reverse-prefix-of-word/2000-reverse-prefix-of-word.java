class Solution {
    public String reversePrefix(String word, char ch) {
        int n = word.length();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        
        while(i<n && word.charAt(i) != ch){
            i++;
        }
        if(i == n){
            return word;
        }
        sb.append(word.substring(0,i+1)).reverse().append(word.substring(i+1));
        return sb.toString();
    }
}