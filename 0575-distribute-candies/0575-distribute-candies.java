class Solution {
    public int distributeCandies(int[] candyType) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<candyType.length;i++){
            set.add(candyType[i]);
        }
        int maxEat = candyType.length/2;
        if(set.size()<=maxEat){
            return set.size();
        }else{
            return maxEat;
        }
    }
}