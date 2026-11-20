class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen=new HashSet<>();
        while(n!=1 && !seen.contains(n)){
            seen.add(n);
            n=sumSquare(n);
        }
        return n==1;
    }
    private int sumSquare(int n){
        int sum=0;
        while(n>0){
            int digit=n%10;
            n/=10;
            sum+=digit*digit;
        }
        return sum;
    }
}
