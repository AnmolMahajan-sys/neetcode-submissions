class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1) return intervals;

        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> result=new ArrayList<>();
        int[] curr=intervals[0];
        result.add(curr);

        for(int i=1;i<intervals.length;i++){
            int[] interval=intervals[i];

            int currEnd=curr[1];
            int nextStart=interval[0];
            int nextEnd=interval[1];

            if(nextStart<=currEnd){
                curr[1]=Math.max(currEnd,nextEnd);
            }else{
                curr=interval;
                result.add(curr);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
