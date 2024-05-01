class Solution {
    public String reversePrefix(String word, char ch) {
        StringBuilder sb = new StringBuilder();
        int i=0;
        while(i<word.length() && word.charAt(i) != ch){
            i++;
        }
        if(i >= word.length()){
            return word;
        }
        sb.append(word.substring(0,i+1)).reverse();
        return sb.toString() + word.substring(i+1);
    }
}