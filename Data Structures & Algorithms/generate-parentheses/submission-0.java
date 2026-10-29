class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<>();
        backtrack(result,0,0,"",n);
        return result;
    }
    private void backtrack(List<String> result,int open,int close,String curr,int n){
        if(curr.length()==2*n){
            result.add(curr);
            return;
        }
        if(open<n){
            backtrack(result,open+1,close,curr+'(',n);
        }
        if(close<open){
             backtrack(result,open,close+1,curr+')',n);
        }
    }
}
