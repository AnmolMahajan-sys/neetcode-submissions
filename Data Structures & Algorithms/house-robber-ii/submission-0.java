class Solution {
    public int rob(int[] nums) {
      int n=nums.length;

      if(n==1) return nums[0];

      int case1=effRob(nums,0,n-2);
      int case2=effRob(nums,1,n-1);

      return Math.max(case1,case2);  
    }

    private int effRob(int[] nums,int start,int end){
        int sum1=0;
        int sum2=0;

        for(int i=start;i<=end;i++){
            int sum=Math.max(sum1,sum2+nums[i]);
            sum2=sum1;
            sum1=sum;
        }
        return sum1;
    }
}
