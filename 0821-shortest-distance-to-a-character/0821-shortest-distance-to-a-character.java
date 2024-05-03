class Solution {
    public int[] shortestToChar(String s, char c) {
        int arr [] = new int[s.length()];
        ArrayList<Integer> index = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == c){
                index.add(i);
            }
        }
        for(int i=0;i<s.length();i++){
            arr[i] = Integer.MAX_VALUE;
            for(int j=0;j<index.size();j++){
                arr[i] = Math.min(arr[i],Math.abs(i-index.get(j)));
            }
        }
        return arr;
    }
}