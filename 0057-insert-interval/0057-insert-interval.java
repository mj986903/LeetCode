class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int start = newInterval[0], end = newInterval[1];
        boolean inserted = false;
        
        for(int[] inv : intervals){
            int nextStart = inv[0], nextEnd = inv[1];
            if (nextEnd < start || inserted) {
                ans.add(new int[]{nextStart, nextEnd});
                continue;
            }
            start = Math.min(start, nextStart);
            if (end < nextStart) {
                ans.add(new int[]{start, end});
                ans.add(new int[]{nextStart, nextEnd});
                inserted = true;
                continue;
            }
            if (end <= nextEnd) {
                ans.add(new int[]{start, nextEnd});
                inserted = true;
            }
        }
        if(!inserted){
            ans.add(new int[]{start, end});
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
