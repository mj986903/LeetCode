class Solution {
    private static void DFS(List<List<Integer>> list,int root,int prev,int[] sum, int[] count){
        for (int i : list.get(root)) {
            if (i == prev) {
                continue;
            }
            DFS(list,i, root,sum,count);
            count[root] += count[i];
            sum[root] += sum[i] + count[i];
        }
        count[root]++;
    }
    private static void DFS2(List<List<Integer>> list, int root,int prev,int[] sum, int[] count){
        for (int i : list.get(root)) {
            if (i == prev) {
                continue;
            }
            sum[i] = sum[root] - count[i] + count.length - count[i];
            DFS2(list,i, root,sum,count);
        }
    }
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjacencyList.add(new ArrayList<>());
        }
        for(int [] edge : edges){
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }        
        int sum [] = new int [n];
        int count [] = new int [n];
        
        DFS(adjacencyList,0,-1,sum,count);
        DFS2(adjacencyList,0,-1,sum,count);
        
        return sum;
    }
}