class Solution {
    private static int helper(int [][] grid, int i,int j){
        int count = 0;
        if(i-1>=0 && grid[i-1][j] == 1){
            count++;
        }
        if(i+1<grid.length && grid[i+1][j] == 1){
            count++;
        }
        if(j-1>=0 && grid[i][j-1] == 1){
            count++;
        }
        if(j+1<grid[0].length && grid[i][j+1] == 1){
            count++;
        }
        return count;
    }
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    perimeter = perimeter + 4 - helper(grid,i,j);
                }
            }
        }
        return perimeter;
    }
}