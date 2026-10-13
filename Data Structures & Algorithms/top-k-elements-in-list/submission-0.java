class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums)
            map.put(num,map.getOrDefault(num,0)+1);
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(a[1]-b[1]));

        for(int num:map.keySet()){
            pq.add(new int[]{num,map.get(num)});

            if(pq.size()>k) pq.poll();

        }
        int[] res=new int[k];
        for(int i=0;i<k;i++){
            res[i]=pq.poll()[0];
        }
        return res;

    }
}
