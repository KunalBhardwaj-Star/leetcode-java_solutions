class TrieNode {
    TrieNode[] child = new TrieNode[2];
    int count;
}

class Trie {

    TrieNode root = new TrieNode();

    public void insert(int num) {

        TrieNode node = root;

        for (int bit = 14; bit >= 0; bit--) {

            int currBit = (num >> bit) & 1;

            if (node.child[currBit] == null) {
                node.child[currBit] = new TrieNode();
            }

            node = node.child[currBit];
            node.count++;
        }
    }

    public int countLessThan(int num, int limit) {

        TrieNode node = root;
        int ans = 0;

        for (int bit = 14; bit >= 0; bit--) {

            if (node == null) {
                break;
            }

            int numBit = (num >> bit) & 1;
            int limitBit = (limit >> bit) & 1;

            if (limitBit == 1) {

                if (node.child[numBit] != null) {
                    ans += node.child[numBit].count;
                }

                node = node.child[1 - numBit];

            } else {
                node = node.child[numBit];
            }
        }

        return ans;
    }
}

class Solution {

    public int countPairs(int[] nums, int low, int high) {

        Trie trie = new Trie();

        int ans = 0;

        for (int num : nums) {

            ans += trie.countLessThan(num, high + 1);
            ans -= trie.countLessThan(num, low);

            trie.insert(num);
        }

        return ans;
    }
}