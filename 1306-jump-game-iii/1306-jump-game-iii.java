class Solution {

    public boolean dfs(int[] arr, int start, boolean[] visited) {

        if (start < 0 || start >= arr.length) {
            return false;
        }

        if (visited[start]) {
            return false;
        }

        if (arr[start] == 0) {
            return true;
        }

        visited[start] = true;

        return dfs(arr, start + arr[start], visited)
                || dfs(arr, start - arr[start], visited);
    }

    public boolean canReach(int[] arr, int start) {

        boolean[] visited = new boolean[arr.length];

        return dfs(arr, start, visited);
    }
}