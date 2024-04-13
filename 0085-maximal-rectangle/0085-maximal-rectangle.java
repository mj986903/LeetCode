class Solution {
    private int getMaximumArea(int[] height) {
        Stack<Integer> st = new Stack<>();
        int area=0;
        for(int i=0;i<=height.length;i++){
            while (!st.isEmpty() && (i==height.length || height[st.peek()]>=height[i])) {
                int newHeight = height[st.pop()];
                int width = st.isEmpty() ? i : i - st.peek() - 1;
                area = Math.max(area, width * newHeight);
            }
            st.push(i);
        }
        return area;
    }
    public int maximalRectangle(char[][] matrix){
        int area = 0;
        int[] height = new int[matrix[0].length];
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == '0'){
                    height[j] = 0;
                }else if(matrix[i][j]=='1'){
                    height[j]++;
                }
            }
            int currentMaximumArea = getMaximumArea(height);
            area = Math.max(area, currentMaximumArea);
        }
        return area;
    }
}