class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String temp = strs[i];
            char arr [] = temp.toCharArray();
            Arrays.sort(arr);
            if(map.containsKey(String.valueOf(arr))){
                map.get(String.valueOf(arr)).add(strs[i]);
            }else{
                List<String> each = new ArrayList<>();
                each.add(strs[i]);
                map.put(String.valueOf(arr),each);
            }
        }
        for(List<String> temp : map.values()){
            ans.add(temp);
        }
        return ans;
    }
}