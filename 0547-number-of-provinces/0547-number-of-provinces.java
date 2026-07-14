class Solution {
    private class UnionFind{
        private int[] parents;
        private int[] rank;
        private int components;

        public UnionFind(int n){
            parents = new int[n];
            rank = new int[n];
            components = n;

            for(int i = 0; i < n ; i++){
                parents[i] = i;
            }
        }

        private int find(int x){
            if(parents[x] != x){
                parents[x] = find(parents[x]);
            }

            return parents[x];
        }

        private boolean union(int x , int y){
            int rootX = find(x);
            int rootY = find(y);

            if(rootX == rootY)
                return false;
            
            if(rank[rootX] > rank[rootY]){
                parents[rootY] = rootX;
            } else if(rank[rootX] < rank[rootY]){
                parents[rootX] = rootY;
            } else{
                parents[rootY] = rootX;
                rank[rootX]++;
            }

            components--;
            return true;
        }

        public int getComponents(){
            return components;
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(isConnected[i][j] == 1){
                    uf.union(i , j);
                }
            }
        }

        return uf.getComponents();
    }
}