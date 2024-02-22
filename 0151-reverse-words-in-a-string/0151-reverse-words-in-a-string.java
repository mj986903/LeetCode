class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String [] strArr = s.split(" ");
        for(int i=strArr.length-1;i>=0;i--){
            if(strArr[i].length() != 0){
                if(sb.length() != 0){
                    sb.append(" ");
                }
                sb.append(strArr[i]);
            }
        }
        return sb.toString();
    }
}