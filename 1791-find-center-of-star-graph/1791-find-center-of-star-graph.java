class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length , center = 0;
        
        for(int i = 0 ; i < n-1 ; i++){
            if(edges[i][0] == edges[i+1][0] || edges[i][0] == edges[i+1][1]) center = edges[i][0];
            else if(edges[i][1] == edges[i+1][0] || edges[i][1] == edges[i+1][1]) center = edges[i][1];
        }

        return center;
    }
}