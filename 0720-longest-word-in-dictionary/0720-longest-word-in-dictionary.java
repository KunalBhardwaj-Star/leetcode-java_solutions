import java.util.*;

class Solution {
    class Trie{
        Trie children[] = new Trie[26];
        boolean eow;
        Trie(){
            for(int i = 0 ; i < 26 ; i++){
                children[i] = null;
            }
        }
    }

    
    Trie root = new Trie();

    public void insert(String word){
        Trie curr = root;
        for(int i = 0 ; i < word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Trie();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public String ans = "";

    public String longestPrefix(Trie base , StringBuilder temp){

         if(root == null){
            return "";
         }

        for(int i = 0 ; i < 26 ; i++){
            if(base.children[i] != null && base.children[i].eow){
                temp.append((char)(i + 'a'));
                if(temp.length() > ans.length()){
                    ans = temp.toString();
                }
                longestPrefix(base.children[i] , temp);
                temp.deleteCharAt(temp.length() - 1);
            }
        }
        return ans;
    }

    public String longestWord(String[] words) {
        for(String word : words){
            insert(word);
        }
       return longestPrefix(root , new StringBuilder());
    }
}