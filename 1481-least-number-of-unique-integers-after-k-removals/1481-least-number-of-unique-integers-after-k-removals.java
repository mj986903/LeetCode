class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i]) + 1);
            }else{
                map.put(arr[i],1);
            }
        }
        List<Integer> listCount = new ArrayList<>();
        for(int i : map.keySet()){
            listCount.add(map.get(i));
        }
        int [] count = new int [listCount.size()];
        for(int i=0;i<listCount.size();i++){
            count[i] = listCount.get(i);
        }
        Arrays.sort(count);
        int ans = 0;
        for(int i=0;i<count.length;i++){
            if(k>count[i]){
                k = k - count[i];
                count[i]=0;
            }else{
                count[i] = count[i] - k;
                k=0;
            }
            if(count[i] != 0){
                ans++;
            }
        }
        return ans;
    }
}