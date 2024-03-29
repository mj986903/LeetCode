class Solution {
    public int climbStairs(int n) {
        int memory [] = new int[n+1]; 
        memory[0] = 1;
        memory[1] = 1;
        for(int i=2;i<=n;i++){
            memory[i] = memory[i-1] + memory[i-2];
        }
        return memory[n];
    }
}