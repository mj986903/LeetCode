class Solution {
    public int gcd(int a, int b) {
        if(b>0){
            return gcd(b,a%b);
        }
        return a;
    }
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        for(int card : deck){
            map.put(card,map.getOrDefault(card,0)+1);
        }
        for(int key : map.values()){
            ans = gcd(key,ans);
        }
        if(ans <= 1){
            return false;
        }
        return true;
    }
}