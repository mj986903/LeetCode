class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for(String c : tokens){
            if(c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")){
                int v2 = s.pop();
                int v1 = s.pop();
                int result;
                if(c.equals("+")){
                    result = v1+v2;
                }else if(c.equals("-")){
                    result = v1-v2;
                }else if(c.equals("*")){
                    result = v1*v2;
                }else{
                    result = v1/v2;
                }
                s.push(result);
            }else{
                s.push(Integer.parseInt(c));
            }
        }
        return s.peek();
    }
}