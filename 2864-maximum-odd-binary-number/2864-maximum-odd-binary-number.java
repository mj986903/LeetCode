class Solution {
    public String maximumOddBinaryNumber(String s) {
        String ans = "";
        int count1 = 0;
        int count2 = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '0'){
                count1++;
            }else{
                count2++;
            }
        }
        while(count2 != 1){
            ans = ans + '1';
            count2--;
        }
        while(count1 != 0){
            ans = ans + '0';
            count1--;
        }
        ans = ans + '1';
        return ans;
    }
}