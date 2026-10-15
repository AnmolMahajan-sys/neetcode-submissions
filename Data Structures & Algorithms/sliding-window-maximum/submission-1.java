class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
          int n=nums.length;
        int[] result=new int[n-k+1];
        int left=0;
        int index=0;
        int max=Integer.MIN_VALUE,maxIndex=-1;

        for(int right=0;right<n;right++){
            if(nums[right]>=max){
                max=nums[right];
                maxIndex=right;
            }
            if(right-left+1==k){
            result[index++]=max;

            if(maxIndex==left){
                max=Integer.MIN_VALUE;

                for(int i=left+1;i<=right;i++){
                    if(nums[i]>=max){
                        max=nums[i];
                        maxIndex=i;
                    }
                }
            }
            left++;
            } 
        }
        return result;
    }
}
