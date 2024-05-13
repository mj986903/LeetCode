class Solution {
    private void flipRow(int[][] grid, int row) {
        for (int col = 0; col < grid[0].length; col++) {
            grid[row][col] = 1 - grid[row][col];
        }
    }
    private void flipCol(int[][] grid, int col){
        for(int row = 0; row < grid.length; row++){
            grid[row][col] = 1 - grid[row][col];
        }
    }
    private int checkRow(int[] nums){
        int result = 0;
        for(int num : nums) {
            result = result*2+num;
        }
        return result;
    }
    public int matrixScore(int[][] grid){
        int nRows = grid.length;
        int nCols = grid[0].length;
        for(int row = 0; row < nRows; row++){
            if (grid[row][0] == 0) {
                flipRow(grid, row);
            }
        }
        for(int col = 1; col < nCols; col++){
            int countOne = 0;
            for(int row = 0; row < nRows; row++) {
                if (grid[row][col] == 1) {
                    countOne++;
                }
            }
            if(countOne*2 < nRows){
                flipCol(grid, col);
            }
        }
        int totalScore = 0;
        for (int[] row : grid) {
            totalScore = totalScore + checkRow(row);
        }
        return totalScore;
    }
}