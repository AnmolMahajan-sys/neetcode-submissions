class Solution {
    static Map<Character,String> map=new HashMap<>();
    public List<String> letterCombinations(String digits) {
        List<String>list=new ArrayList<>();
        if(digits.length()==0||digits==null) return list;

        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        backtrack(digits,0,new StringBuilder(),list);
        return list;
    }
    private void backtrack(String digits,int index,StringBuilder result,List<String> list){
        if(index==digits.length()){
            list.add(result.toString());
            return;
        }
        String letters=map.get(digits.charAt(index));

        for(char ch:letters.toCharArray()){
            result.append(ch);
            backtrack(digits,index+1,result,list);
            result.deleteCharAt(result.length()-1);
        }
    }
}
