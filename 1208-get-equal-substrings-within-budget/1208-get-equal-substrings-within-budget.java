class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int start = 0;
        int end = 0;
        int cost = 0;
        int length = 0;

        while(end<s.length()){
            cost = cost + Math.abs(s.charAt(end)-t.charAt(end));
            while (cost > maxCost) {
                cost = cost - Math.abs(s.charAt(start)-t.charAt(start));
                start++;
            }
            length = Math.max(length, end-start+1);
            end++;
        }
        return length;
    }
}
