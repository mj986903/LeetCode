class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for(int i=0;i<nums1.length;i++){
            set.add(nums1[i]);
        }
        for(int j=0;j<nums2.length;j++){
            if(set.contains(nums2[j])){
                set2.add(nums2[j]);
            }
        }
        int ans [] = new int [set2.size()];
        int idx=0;
        for(int i : set2){
            ans[idx++] = i;
        }
        return ans;
    }
}