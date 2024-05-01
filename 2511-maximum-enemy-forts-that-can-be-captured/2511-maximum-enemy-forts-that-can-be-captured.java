class Solution {
    public int captureForts(int[] forts) {
        int c=0;
        int max=0;
        boolean one=false;
        boolean minus=false;
        
        for(int i:forts){
            if((one||minus)&&i==0){
                c++;
            }
            if(i==-1 &&one){
                max=Math.max(max,c);
                c=0;
                one=false;
                minus=true;
            }
            if(i==1 &&minus){
                max=Math.max(max,c);
                c=0;
                one=true;
                minus=false;
            }
            if(minus &&i==-1||one &&i==1){
                c=0;
            }
             if(i==1){
                one=true;
            }
            if(i==-1){
                minus=true;
            }
        }
        return max;
    }
}