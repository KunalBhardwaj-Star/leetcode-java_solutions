class Solution {
    public void createGraph(List<List<Integer>> connections  , int n , List<List<Integer>> newConnections){
        for(int i = 0  ;i < n ; i++){
            newConnections.add(new ArrayList<>());
        }

        for(int i = 0 ; i < connections.size(); i ++){
            int fir = connections.get(i).get(0) , sec = connections.get(i).get(1);
            newConnections.get(fir).add(sec);
            newConnections.get(sec).add(fir);
        }
    }
    
    public void dfs(List<List<Integer>> newConnections,int curr , int par , int[]dt , int[]low , boolean[] vis , int time , List<List<Integer>> ans){
        vis[curr] = true;
        dt[curr] =  low[curr] = ++time;
        for(int i = 0 ; i < newConnections.get(curr).size(); i++){
            if (par == newConnections.get(curr).get(i)) continue;
            else if(!vis[newConnections.get(curr).get(i)]){
                dfs(newConnections , newConnections.get(curr).get(i) , curr , dt , low , vis , time , ans);
                low[curr] = Math.min(low[curr] , low[newConnections.get(curr).get(i)]);
                if(dt[curr] < low[newConnections.get(curr).get(i)]){
                    ArrayList<Integer> a = new ArrayList<>();
                    a.add(curr);
                    a.add(newConnections.get(curr).get(i));
                    ans.add(a);
                }
            }
            else{
                low[curr] = Math.min(low[curr] , dt[newConnections.get(curr).get(i)]);
            }
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int [] dt = new int[n];
        int [] low = new int[n];
        boolean[] vis = new boolean[n];
        int time = 0;
 
        List<List<Integer>> newConnections = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0  ;i < n ; i++){
            newConnections.add(new ArrayList<>());
        }
        createGraph(connections , n , newConnections);

        for(int i = 0 ; i < n; i++){
            if(!vis[i]){
                dfs(newConnections ,i , -1 ,dt , low , vis , time , ans);
            }
        }
        return ans;
    }
}