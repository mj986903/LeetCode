class Solution {
    public String minRemoveToMakeValid(String s) {
        String temp = "";
        Stack<Character> st = new Stack<>();
        
        for(char c : s.toCharArray()){
            if(!st.isEmpty() && st.peek()=='(' && c==')'){
                st.pop();
            }else if(st.isEmpty() && c==')'){
                continue;
            }else if(c == '('){
                st.push(c);
            }
            temp += c;
        }
        
        while(!st.isEmpty()){
            st.pop();
        }
        
        String ans = "";
        for(int i=temp.length()-1;i>=0;i--){
            char c = temp.charAt(i);
            if(!st.isEmpty() && st.peek()==')' && c=='('){
                st.pop();
            }else if(st.isEmpty() && c=='('){
                continue;
            }else if(c == ')'){
                st.push(c);
            }
            ans = c + ans;
        }
        return ans;
    }
}