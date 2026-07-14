class Solution {
    private void dfs(int idx , int[][] isConnected , boolean[] vis){
        for(int i = 0 ; i < isConnected[idx].length ; i++){
            if(isConnected[idx][i] == 1 && !vis[i]){
                vis[i] = true;
                dfs(i , isConnected , vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];

        int count = 0;

        for(int i = 0 ; i < n ; i++){
            if(!vis[i]){
                dfs(i , isConnected , vis);
                count++;
            }
        }

        return count;
    }
}