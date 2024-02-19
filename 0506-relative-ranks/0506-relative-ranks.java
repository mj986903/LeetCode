class Solution {
    public String[] findRelativeRanks(int[] score) {
        HashMap<Integer,String> map = new HashMap<>();
        String  []ans = new String [score.length];
        int [] sortScore = new int [score.length];
        for(int i=0;i<score.length;i++){
            sortScore[i] = score[i];
        }
        Arrays.sort(sortScore);
        int count = 1;
        for(int i=sortScore.length-1;i>=0;i--){
            if(count == 1){
                map.put(sortScore[i],"Gold Medal");
                count++;
            }else if(count == 2){
                map.put(sortScore[i],"Silver Medal");
                count++;
            }else if(count == 3){
                map.put(sortScore[i],"Bronze Medal");
                count++;
            }else{
                map.put(sortScore[i],String.valueOf(count));
                count++;
            }
        }
        for(int i=0;i<score.length;i++){
            ans[i] = map.get(score[i]);
        }
        return ans;
    }
}