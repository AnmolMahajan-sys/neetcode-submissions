class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums,target,result,new ArrayList<>(),0,0);
        return result;
    }
    private void backtrack(int[] nums,int target,List<List<Integer>> result,List<Integer> curr,int start,int sum){
        if(sum==target){
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i=start;i<nums.length;i++){
            if(sum+nums[i]>target) break;

            curr.add(nums[i]);
            backtrack(nums,target,result,curr,i,sum+nums[i]);
            curr.remove(curr.size()-1);
        }
    }
}
