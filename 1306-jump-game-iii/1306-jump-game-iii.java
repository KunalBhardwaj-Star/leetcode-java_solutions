class Solution {
    private boolean dfs(int[] arr , int start , boolean[] vis){
        if(start < 0 || start >= arr.length)
            return false;

        if(vis[start])
            return false;

        if(arr[start] == 0)
            return true;

        vis[start] = true;

        return dfs(arr , arr[start] + start , vis) || dfs(arr , start - arr[start] , vis);
    }
    public boolean canReach(int[] arr, int start) {
        int len = arr.length;

        boolean[] vis = new boolean[len];

        return dfs(arr , start , vis);
    }
}