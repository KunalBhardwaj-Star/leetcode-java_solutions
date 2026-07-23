class Solution {
    private class TrieNode{
        TrieNode[] child = new TrieNode[2];
    }

    private class Trie{
        TrieNode root;

        public Trie(){
            root = new TrieNode();
        }

        public void insert(int num){
            TrieNode node = root;

            for(int bit = 31 ; bit >= 0 ; bit--){
                int currBit = (num >> bit) & 1;
                
                if(node.child[currBit] == null){
                    node.child[currBit] = new TrieNode();
                }

                node = node.child[currBit];
            }
        }

        public int maxVal(int num){
            TrieNode node = root;

            int ans = 0;

            for(int bit = 31 ; bit >= 0 ; bit--){
                int currBit = (num >> bit) & 1;
                int desired = 1 - currBit;

                if(node.child[desired] != null){
                    ans |= (1 << bit);
                    node = node.child[desired];
                } else {
                    node  = node.child[currBit];
                }
            }

            return ans;
        }
    }

    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();

        int ans = 0;

        trie.insert(nums[0]);

        for(int i = 1 ; i < nums.length ; i++){
            ans = Math.max(ans , trie.maxVal(nums[i]));

            trie.insert(nums[i]);
        }

        return ans;
    }
}