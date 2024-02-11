class Solution {
    private static int memo [][][];
    
    public int cherryPickup(int[][] grid) {
        memo = new int [grid.length] [grid[0].length] [grid[0].length];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[i].length; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return helper(grid,0,0,grid[0].length-1);
    }
    
    private static int helper(int [][] grid,int x,int y1,int y2){
        if(x<0 || x>=grid.length || y1<0 || y1>=grid[0].length || y2<0 || y2>=grid[0].length){
            return 0;
        }
        if(memo[x][y1][y2] != -1){
             return memo[x][y1][y2];
        }
        int result = grid[x][y1];
        if(y1!=y2){
            result = result + grid[x][y2];
        }
        int max = Integer.MIN_VALUE;
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                max = Math.max(max,helper(grid,x+1,y1+i,y2+j));
            }
        }
        result = result + max;
        memo[x][y1][y2] = result;
        return result;
    }
}