class Solution {
    public String interpret(String command) {
        boolean bracket = false;
        String ans = "";
        for(int i=0;i<command.length();i++){
            if(command.charAt(i) == '('){
                bracket = true;
            }else if(bracket && command.charAt(i) != ')'){
                ans = ans + command.charAt(i);
            }else if(bracket){
                if(command.charAt(i) == ')' && command.charAt(i-1) == '('){
                    ans = ans + 'o';
                }
            }else if(!bracket){
                ans = ans + command.charAt(i);
            }
        }
        return ans;
    }
}