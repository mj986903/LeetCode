class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        boolean odd = false;
        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(char c : map.keySet()){
            if(map.get(c)%2!=0 && !odd){
                odd = true;
            }else if(map.get(c)%2!=0 && odd){
                map.put(c,map.get(c)-1);
            }
        }
        int count = 0;
        for(char c : map.keySet()){
            count = count + map.get(c);
        }
        return count;
    }
}