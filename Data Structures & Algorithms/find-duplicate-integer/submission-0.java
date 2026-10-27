class Solution {
    public int findDuplicate(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int result=0;
        for(int num:nums){
            if(map.get(num)>1){
                result=num;
            }
        }
        return result;
    }
}
