class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> ans = new ArrayList<>();

        boolean[] track = new boolean[n];
        Arrays.fill(track , true);

        for(int i = 0 ; i < edges.size(); i++){
            int u = edges.get(i).get(0) , v = edges.get(i).get(1);

            track[v] = false;
        }

        for(int i = 0 ; i < n; i++){
            if(track[i]) ans.add(i);
        }

        return ans;
    }
}