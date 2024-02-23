class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int distance [] = new int[n];
        Arrays.fill(distance,Integer.MAX_VALUE);
        
        HashMap<Integer,List<int []>> map = new HashMap<>();
        for(int flight [] : flights){
            int u = flight[0];
            int v = flight[1];
            int cost = flight[2];
            if(map.containsKey(u)){
                map.get(u).add(new int [] {v,cost});
            }else{
                List<int []> temp = new ArrayList<>();
                temp.add(new int [] {v,cost});
                map.put(u,temp);
            }
        }
        
        Queue<int []> q = new LinkedList<>();
        q.offer(new int [] {src,0});
        int steps = 0;
        while(!q.isEmpty() && steps<=k){
            int size = q.size();
            while(size > 0){
                int [] node = q.poll();
                int u = node[0];
                int c = node[1];
                if(map.containsKey(u)){
                    for(int [] edge : map.get(u)){
                        int v = edge[0];
                        int cost = edge[1];
                        if(distance[v] > c+cost){
                            distance[v] = c+cost;
                            q.offer(new int [] {v,c+cost});
                        }
                    }
                }
                size--;
            }
            steps++;
        }
        if(distance[dst] != Integer.MAX_VALUE){
            return distance[dst];
        }
        return -1;
    }
}