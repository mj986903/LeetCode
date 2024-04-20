class Solution {
    public int[][] findFarmland(int[][] land) {
        boolean[][] visited = new boolean[land.length][land[0].length];
        List<int[]> ans = new ArrayList<>();
        for(int i=0;i<land.length;i++){
            for(int j=0;j<land[0].length;j++){
                if(!visited[i][j] && land[i][j]==1){
                    int m = i;
                    int n = j;
                    while(m<land.length && land[m][j]==1){
                        m++;
                    }
                    while(n<land[0].length && land[i][n]==1){
                        n++;
                    }
                    for(int v1=i;v1<m;v1++){
                        for(int v2=j;v2<n;v2++){
                            visited[v1][v2]=true;
                        }
                    }
                    ans.add(new int[]{i,j,m-1,n-1});
                }
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}