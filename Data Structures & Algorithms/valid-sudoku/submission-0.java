class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] row=new HashSet[9];
        Set<Character>[] col=new HashSet[9];
        Set<Character>[] box=new HashSet[9];

        for(int i=0;i<9;i++){
            row[i]=new HashSet<>();
            col[i]=new HashSet<>();
            box[i]=new HashSet<>();
        }
        for(int r=0;r<9;r++){
            for(int c=0;c<9;c++){
                char value=board[r][c];

                if(value=='.') continue;

                int boxInd=(c/3)*3+(r/3);

                if(!(row[r].add(value)&&col[c].add(value)&&box[boxInd].add(value))) return false;
            }
        }
        return true;
    }
}
