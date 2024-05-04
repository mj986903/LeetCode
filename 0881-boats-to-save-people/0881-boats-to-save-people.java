class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int boat = 0;
        Arrays.sort(people);
        int i=0;
        int j=people.length-1;
        while(i<=j){
            int sum = people[i] + people[j];
            if(sum <= limit){
                i++;
            }
            j--;
            boat++;
        }
        return boat;
    }
}