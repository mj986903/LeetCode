class Solution {
    public int maxDepth(String s) {
        if((s.length() == 0) || (s.length() == 1 && s.charAt(0) != '(' && s.charAt(0) != ')')){
            return 0;
        }
        int depth = 0;
        int count = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                count++;
            }
            if(s.charAt(i) == ')'){
                depth = Math.max(depth,count);
                count--;
            }
        }
        return depth;
    }
}