class Solution {
    public boolean isSameAfterReversals(int num) {
        int reverse1 = Integer.parseInt((new StringBuilder(String.valueOf(num))).reverse().toString());
        System.out.println(reverse1);
        int reverse2 = Integer.parseInt((new StringBuilder(String.valueOf(reverse1))).reverse().toString());
        System.out.println(reverse2);
        return num == reverse2;
    }
}