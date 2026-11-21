class Solution {

    private void dfs(List<List<Integer>> adj , int[] parent , int[] newPar , int[] lastOccur , String s , int u){

        int idx = s.charAt(u) - 'a';

        int prev = lastOccur[idx];

        if (prev != -1)
            newPar[u] = prev;
        else
            newPar[u] = parent[u];

        lastOccur[idx] = u;

        for (int x : adj.get(u)) {
            dfs(adj, parent, newPar, lastOccur, s, x);
        }

        lastOccur[idx] = prev;
    }

    private int calculateSize(List<List<Integer>> adj , int[] ans , int x){
        int size = 1;

        for(int i : adj.get(x))
            size += calculateSize(adj , ans , i);

        ans[x] = size;

        return size;
    }

    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0 ; i < n ; i++)
            adj.add(new ArrayList<>());

        for(int i = 1 ; i < n ; i++)
            adj.get(parent[i]).add(i);

        int[] lastOccur = new int[26];
        Arrays.fill(lastOccur , -1);

        int[] newPar = parent;

        dfs(adj , parent , newPar , lastOccur , s , 0);

        List<List<Integer>> newAdj = new ArrayList<>();

        for (int i = 0; i < n; i++)
            newAdj.add(new ArrayList<>());

        for (int i = 1; i < n; i++)
            newAdj.get(newPar[i]).add(i);

        int[] ans = new int[n];

        calculateSize(newAdj , ans , 0);

        return ans;
    }
}