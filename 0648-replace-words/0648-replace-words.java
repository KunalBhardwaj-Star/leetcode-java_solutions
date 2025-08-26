class Solution {
    class Trie{
        Trie children[] = new Trie[26];
        boolean eow;
        Trie (){
            for(int i = 0 ; i < 26 ; i++){
                children[i] = null;
            }
        }
    }

    Trie root = new Trie();

    public void insert(String str){
        Trie curr = root;

        for(char c : str.toCharArray()){
            int idx = c - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Trie();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public String replace(String word){
        Trie curr = root;
        StringBuilder sb = new StringBuilder();
        for(char c : word.toCharArray()){
            int idx = c - 'a';
            if(curr.children[idx] == null) break;
            curr = curr.children[idx];
            sb.append(c);
            if(curr.eow) break;
        }
        return curr.eow ? sb.toString() : word;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        for(String dic : dictionary){
            insert(dic);
        }

        String word[] = sentence.split(" ");
        for(int i = 0 ; i < word.length ; i++){
            word[i] = replace(word[i]);
        }

        return String.join(" " , word);
    }
}