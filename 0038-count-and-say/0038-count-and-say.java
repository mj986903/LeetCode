class Solution {
    public String countAndSay(int n) {
        String ans ="1";
        for(int i=0;i<n-1;i++){
            char c = ans.charAt(0);
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for(int j=1;j<ans.length();j++){
                if(c!=ans.charAt(j)){
                    sb.append(count);
                    sb.append(c);
                    count = 0;
                    c = ans.charAt(j);
                }
                count++;
            }
            sb.append(count);
            sb.append(c);
            ans = sb.toString();
        }
        return ans;
    }
}