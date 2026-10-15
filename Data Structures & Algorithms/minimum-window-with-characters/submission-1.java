class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> map=new HashMap<>();

        int left=0,right=0,count=0;
        int n=s.length(),m=t.length();
        int minLen=Integer.MAX_VALUE;
        int startIndex=-1;

        for(char ch:t.toCharArray()) map.put(ch,map.getOrDefault(ch,0)+1);

        while(right<n){
            char ch=s.charAt(right);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)>=0) count++;
            }
            while(count==m){
                if(right-left+1<minLen){
                    minLen=right-left+1;
                    startIndex=left;
                }
                char leftCh=s.charAt(left);
                if(map.containsKey(leftCh)){
                    map.put(leftCh,map.get(leftCh)+1);
                    if(map.get(leftCh)>0)count--;
                }
                left++;
            }
            right++;
        }
        return startIndex==-1?"":s.substring(startIndex,startIndex+minLen);
    }
}
