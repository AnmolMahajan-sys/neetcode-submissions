class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0")) return "0";
        int m=num1.length(),n=num2.length();
        int[] result=new int[m+n];

        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int d1=num1.charAt(i)-'0';
                int d2=num2.charAt(j)-'0';

                result[i+j+1]+=d1*d2;
            }
        }
        for(int i=result.length-1;i>=0;i--){
            if(result[i]>=10){
                result[i-1]+=result[i]/10;
                result[i]%=10;
            }
        }

        StringBuilder sb=new StringBuilder();
        for(int digit:result){
            if(!(sb.length()==0 && digit==0)){
                sb.append(digit);
            }
        }
        return sb.toString();
    }
}
