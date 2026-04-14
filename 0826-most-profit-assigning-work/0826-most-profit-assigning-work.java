class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        //Profit and Difficulty list length is same
        int n = difficulty.length , m = worker.length;

        ArrayList<int[]> strength = new ArrayList<>();

        for(int i = 0; i < n; i++){
            strength.add(new int[]{difficulty[i], profit[i]});
        }

        Collections.sort(strength, (a, b) -> a[0] - b[0]);
        
        Arrays.sort(worker);

        int maxProf = 0;
        
        for(int i = 0 ; i < m ; i++){
            int currPro = 0;
            for(int j = 0 ; j < n ; j++){
                int[] curr = strength.get(j);
                if(curr[0] > worker[i]) break;
                else currPro = Math.max(currPro , curr[1]);
            }
            
            maxProf += currPro;
        }
        
        return maxProf;
    }
}