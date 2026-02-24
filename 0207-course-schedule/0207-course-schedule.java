class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new ArrayList[numCourses];
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) adj[i] = new ArrayList<>();

        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prerequisite = pre[1];
            adj[prerequisite].add(course); 
            inDegree[course]++;            
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0 ; i < numCourses ; i++){
            if(inDegree[i] == 0) q.add(i);
        }

        int count = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            count++;

            for(int neigh : adj[curr]){
                inDegree[neigh]--;
                if(inDegree[neigh] == 0){
                    q.add(neigh);
                }
            }
        }

        return count == numCourses;
    }
}