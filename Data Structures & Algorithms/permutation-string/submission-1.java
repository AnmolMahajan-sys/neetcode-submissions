class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;

        HashMap<Character,Integer> map=new HashMap<>();

        for(char ch:s1.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int left=0,right=0;
        int count=s1.length();

        while(right<s2.length()){
            char c=s2.charAt(right);
            if(map.containsKey(c)){
                if(map.get(c)>0) count--;
                map.put(c,map.get(c)-1);
            }
            right++;

            while(right-left>s1.length()){
                char cleft=s2.charAt(left);

               if(map.containsKey(cleft)){
                    map.put(cleft,map.get(cleft)+1);
                    if(map.get(cleft)>0)count++;
                }
                left++;
            }
            if(count==0) return true;
        }
        return false;
    }
}
