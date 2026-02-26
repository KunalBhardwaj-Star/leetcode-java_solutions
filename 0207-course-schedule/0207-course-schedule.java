class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int len = prerequisites.length;

        if(numCourses == 1) return true;

        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        int[] incoming = new int[numCourses];

        for(int i = 0 ; i < numCourses ; i++)g.add(new ArrayList<>());

        for(int i = 0 ; i < len ; i++){
            int src = prerequisites[i][1] , des = prerequisites[i][0];
            g.get(src).add(des);
            incoming[des]++;
        }

        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0 ; i < numCourses ; i++){
            if(incoming[i] == 0) q.add(i);
        }

        int count = 0;

        while(!q.isEmpty()){
            int curr = q.remove();
            count++;
            for(int neigh : g.get(curr)){
                incoming[neigh]--;
                if(incoming[neigh] == 0)q.add(neigh);
            }
        }

        return count == numCourses;

    }
}