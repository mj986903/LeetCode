class Solution {
    private static int digitSum(int n){
        int sum = 0;
        while(n != 0){
            int digit = n%10;
            n = n/10;
            sum = sum + (digit*digit);
        }
        return sum;
    }
    public boolean isHappy(int n) {
        Set<Integer> vis = new HashSet<>();
        while (n != 1 && !vis.contains(n)) {
            vis.add(n);
            int sum = digitSum(n);
            n = sum;
        }
        return n == 1;
    }
}