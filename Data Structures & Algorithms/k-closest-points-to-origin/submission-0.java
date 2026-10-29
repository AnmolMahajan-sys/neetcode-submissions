class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap=new PriorityQueue<>((a,b)->b[0]-a[0]);
        for(int i=0;i<points.length;i++){
            int dist=points[i][0]*points[i][0]+points[i][1]*points[i][1];
            maxHeap.offer(new int[]{dist,i});

            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }

        int results[][]=new int[k][2];
        int idx=0;
        while(!maxHeap.isEmpty()){
            int pointIndex=maxHeap.poll()[1];
            results[idx++]=points[pointIndex];
        } 
        return results;

    }
}
