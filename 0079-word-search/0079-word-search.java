class Solution {
    public static boolean dfs(char[][] board, String word, boolean visited [][], int i, int j,int count){
        if (count == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(count)) {
            return false;
        }
        visited[i][j] = true;
        
        if (dfs(board, word, visited, i + 1, j, count + 1) ||dfs(board, word, visited, i - 1, j, count + 1) || dfs(board, word, visited, i, j + 1, count + 1) || dfs(board, word, visited, i, j - 1, count + 1)) {
            return true;
        }
        
        visited[i][j] = false;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        boolean visited [][] = new boolean[board.length][board[0].length];
        boolean result = false;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if (board[i][j] == word.charAt(0)) {
                    result = dfs(board, word, visited, i, j, 0);
                    if(result){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}