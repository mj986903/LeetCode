class Solution {
    public int numOfStrings(String[] patterns, String word) {
        List<String> set = new ArrayList<>(Arrays.asList(patterns));
        System.out.println(set);
        int count = 0;
        for(int i=0;i<word.length();i++){
            for(int j=i;j<word.length();j++){
                System.out.println(word.substring(i,j+1));
                while(set.contains(word.substring(i,j+1))){
                    set.remove(word.substring(i,j+1));
                    count++;
                }
            }
        }
        return count;
    }
}