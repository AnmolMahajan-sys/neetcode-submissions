class Solution {
    public int characterReplacement(String s, int k) {
       int n=s.length();
       int low=0, res=Integer.MIN_VALUE;
       int[] freq=new int[26];

       for(int high=0;high<n;high++){
        freq[s.charAt(high)-'A']++;
        int maxCount=find(freq);
        int len=high-low+1;
        int diff=len-maxCount;

        while(diff>k){
            freq[s.charAt(low)-'A']--;
            low++;
            maxCount=find(freq);
            len=high-low+1;
            diff=len-maxCount;
        }
        len=high-low+1;
        res=Math.max(res,len);
       }
       return res;
    }
    private int find(int[] a){
        int maxCount=1;
        for(int i=0;i<26;i++){
            maxCount=Math.max(a[i],maxCount);
        }
        return maxCount;
    }
}
