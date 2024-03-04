class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int n = tokens.length-1;
        int score = 0;
        Arrays.sort(tokens);
        int maxIndex = n;
        int i = 0;
        while(i <= maxIndex){
            if(tokens[i] <= power){
                score++;
                power -= tokens[i];
                i++;
            }else{
                if(score < 1){
                    return score;
                }else if (i != maxIndex){
                    score--;
                    power += tokens[maxIndex];
                    maxIndex--;
                }else{
                    return score;
                }
            }
        }
        return score;
    }
}