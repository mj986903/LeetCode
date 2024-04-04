class Solution {
    public String convertToTitle(int columnNumber) {
        String ans = "";
        while(columnNumber != 0){
            int index = (columnNumber - 1) % 26;
            ans = (char) ('A' + index) + ans;
            columnNumber = (columnNumber - 1) / 26;
        }
        return ans;
    }
}