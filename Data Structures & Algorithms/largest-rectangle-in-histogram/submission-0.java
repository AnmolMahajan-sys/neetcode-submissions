class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int maxArea=0;
        Stack<Integer> stack=new Stack<>();

        for(int i=0;i<=n;i++){
            int currHeight=(i==n)?0:heights[i];

            while(!stack.isEmpty() && heights[stack.peek()]>currHeight){
                int height=heights[stack.pop()];
                int width;

                if(stack.isEmpty()){
                    width=i;
                }else{
                    width=i-stack.peek()-1;
                }
                maxArea=Math.max(height*width,maxArea);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
