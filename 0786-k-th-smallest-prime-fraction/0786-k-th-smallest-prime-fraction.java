class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        HashMap<Double,List<Integer>> map = new HashMap<>();
        List<Double> fraction = new ArrayList<>();
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                double temp = arr[i]/(double)arr[j];
                List<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                list.add(arr[j]);
                map.put(temp,list);
                fraction.add(temp);
            }
        }
        Collections.sort(fraction);
        int[] ans = map.get(fraction.get(k-1)).stream().mapToInt(Integer::intValue).toArray();
        return ans;
    }
}