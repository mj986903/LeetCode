class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int fuel = 0;
        int totalFuel = 0;
        for(int i=0;i<cost.length;i++){
            totalFuel = totalFuel + gas[i] - cost[i];
            fuel = fuel + gas[i] - cost[i];
            if(fuel < 0){
                fuel = 0;
                start = i+1;
            }
        }
        if(totalFuel < 0){
            return -1;
        }
        return start;
    }
}