class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates,target,result,new ArrayList<>(),0,0);
        return result;
    }
    private void backtrack(int[] candidates,int target,List<List<Integer>> result, List<Integer> curr,int start,int sum){
        if(sum==target){
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if(i>start && candidates[i]==candidates[i-1]) continue;
            if(sum+candidates[i]>target) break;
            curr.add(candidates[i]);
            backtrack(candidates,target,result,curr,i+1,sum+candidates[i]);
            curr.remove(curr.size()-1);
        }
    }
}
