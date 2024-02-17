class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int diff = 0;
        for(int i=0;i<heights.length-1;i++){
            diff = heights[i+1] - heights[i];
            if(diff > 0){
                minHeap.offer(diff);
                if(minHeap.size() > ladders){
                    bricks = bricks - minHeap.poll();
                }
                if(bricks < 0){
                    return i;
                }
            }
        }
        return heights.length - 1;
    }
}