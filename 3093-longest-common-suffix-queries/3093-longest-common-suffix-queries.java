class Solution {

    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        int bestIdx = -1;
    }

    TrieNode root = new TrieNode();

    String[] wordsContainer;

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {

        this.wordsContainer = wordsContainer;

        for (int i = 0; i < wordsContainer.length; i++) {
            insert(wordsContainer[i], i);
        }

        int[] ans = new int[wordsQuery.length];

        for (int i = 0; i < wordsQuery.length; i++) {
            ans[i] = query(wordsQuery[i]);
        }

        return ans;
    }

    private void insert(String word, int idx) {

        TrieNode node = root;

        updateBest(node, idx);

        for (int i = word.length() - 1; i >= 0; i--) {

            int ch = word.charAt(i) - 'a';

            if (node.child[ch] == null) {
                node.child[ch] = new TrieNode();
            }

            node = node.child[ch];

            updateBest(node, idx);
        }
    }

    private void updateBest(TrieNode node, int idx) {

        if (node.bestIdx == -1) {
            node.bestIdx = idx;
            return;
        }

        String curr = wordsContainer[node.bestIdx];
        String next = wordsContainer[idx];

        if (next.length() < curr.length()) {
            node.bestIdx = idx;
        }

        else if (next.length() == curr.length()
                && idx < node.bestIdx) {

            node.bestIdx = idx;
        }
    }

    private int query(String word) {

        TrieNode node = root;

        for (int i = word.length() - 1; i >= 0; i--) {

            int ch = word.charAt(i) - 'a';

            if (node.child[ch] == null) {
                break;
            }

            node = node.child[ch];
        }

        return node.bestIdx;
    }
}