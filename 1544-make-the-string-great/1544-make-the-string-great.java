class Solution {
    public String makeGood(String s) {
        Stack<Character> st = new Stack();
        for(char c : s.toCharArray()){
            if(st.isEmpty()){
                st.push(c);
                continue;
            }
            if((Character.isUpperCase(c) && Character.isLowerCase(st.peek()) && Character.toUpperCase(st.peek()) == c) || Character.isUpperCase(st.peek()) && Character.isLowerCase(c) && Character.toUpperCase(c) == st.peek()){
                st.pop();
            }else{
                st.push(c);
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()){
            ans.insert(0,st.pop());
        }
        return ans.toString();
    }
}