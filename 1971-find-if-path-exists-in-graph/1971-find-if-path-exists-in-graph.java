import java.util.*;

class Solution {
    public void createG(int[][]g , int n , ArrayList<ArrayList<Integer>> ed){
        for(int i = 0 ; i < n ; i++){
            ed.add(new ArrayList<>());
        }
        for(int i = 0 ; i < g.length; i++){
            ed.get(g[i][0]).add(g[i][1]);
            ed.get(g[i][1]).add(g[i][0]);
        }
    }
    public boolean helperFunc(ArrayList<ArrayList<Integer>> ed , int src , int des){
        boolean[] vis = new boolean[ed.size()];
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        vis[src] = true;

        while(!q.isEmpty()){
            int curr = q.remove();
            for(int i = 0 ; i < ed.get(curr).size(); i++){
                if(!vis[ed.get(curr).get(i)]){
                    vis[ed.get(curr).get(i)] = true;
                    q.add(ed.get(curr).get(i));
                }
            }
        }
        return vis[des];
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) return true;
        ArrayList<ArrayList<Integer>> ed = new ArrayList<>();
        createG(edges , n, ed);
        return helperFunc(ed , source , destination);
    }
}