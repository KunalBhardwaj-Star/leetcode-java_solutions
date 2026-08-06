class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer>[] graph = new ArrayList[n];

        for(int i = 0 ; i < n ; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < invocations.length; i ++){
            int from = invocations[i][0];
            int to = invocations[i][1];

            graph[from].add(to);
        }

        boolean[] suspicious = new boolean[n];

        dfs(k , suspicious , graph);

        ArrayList<Integer> ans = new ArrayList<>();

        for(int[] x : invocations){
            int from = x[0];
            int to = x[1];

            if(!suspicious[from] && suspicious[to]){
                for(int i = 0; i < n ; i++)
                    ans.add(i);

                return ans;
            }
        }

        for(int i = 0 ; i < n ; i++){
           if(!suspicious[i])
                ans.add(i);
        }

        return ans;
    }

    private void dfs(int node , boolean[] suspicious , List<Integer>[] graph){
        if(suspicious[node])
            return;

        suspicious[node] = true;
        
        for(int x : graph[node]){
            dfs(x , suspicious , graph);
        }
    }
}