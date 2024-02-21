class Solution {
    public static String longestCommonPrefixUtil(String s1, String s2) {
        String result = "";
        int n1 = s1.length();
        int n2 = s2.length();

        for (int i=0, j=0; i<n1 && j<n2; i++, j++) {
            if (s1.charAt(i) != s2.charAt(j)) {
                break;
            }
            result += s1.charAt(i);
        }
        return result;
    }
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for(int i=1;i<strs.length;i++){
            prefix = longestCommonPrefixUtil(prefix,strs[i]);
        }
        return prefix;
    }
}