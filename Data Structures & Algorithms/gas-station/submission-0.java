class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int tGas=0,tCost=0;

        for(int i=0;i<gas.length;i++){
            tGas+=gas[i];
            tCost+=cost[i];
        }
        if(tGas<tCost) return -1;

        int startIndex=0;
        int currgas=0;

        for(int i=0;i<gas.length;i++){
            currgas+=gas[i]-cost[i];

            if(currgas<0){
                startIndex=i+1;
                currgas=0;
            }
        }
        return startIndex;
    }
}
