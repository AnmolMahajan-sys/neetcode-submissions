class WordDictionary {

    class TrieNode{
        TrieNode[] children=new TrieNode[26];
        boolean isEnd;
    }

    TrieNode root;

    public WordDictionary() {
        root=new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr=root;

        for(char c:word.toCharArray()){
            int index=c-'a';

            if(curr.children[index]==null)
                curr.children[index]=new TrieNode();

            curr=curr.children[index];
            
        }
        curr.isEnd=true;
    }

    public boolean search(String word) {
        return dfs(root,word,0);
    }

    private boolean dfs(TrieNode curr, String word,int pos){
        if(pos==word.length()) return curr.isEnd;

        char ch=word.charAt(pos);

        if(ch!='.'){
            int index=ch-'a';

            if(curr.children[index]==null) return false;

            return dfs(curr.children[index],word,pos+1);
        }

        for(int i=0;i<26;i++){
            if(curr.children[i]!=null){
                if(dfs(curr.children[i],word,pos+1)) return true;
            }
        }
        return false;
    }
}
