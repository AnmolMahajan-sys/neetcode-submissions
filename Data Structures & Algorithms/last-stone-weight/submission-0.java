class Solution {
    public int lastStoneWeight(int[] stones) {
        
         PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        for(int s:stones){
            maxHeap.offer(s);
        }
        while(maxHeap.size()>1){
            int heavy=maxHeap.poll();
            int secondHeavy=maxHeap.poll();

            if(heavy!=secondHeavy) maxHeap.offer(heavy-secondHeavy);
        }
        return maxHeap.isEmpty()? 0:maxHeap.poll();
    }
}
