class Solution {
    public int findJudge(int n, int[][] trust) {
        if(trust.length == 0 && n <= 1) return 1;
        int[] incoming = new int[n+1] , outgoing = new int[n+1];

        for(int i = 0 ; i < trust.length; i++){
            incoming[trust[i][1]]++;
            outgoing[trust[i][0]]++;
        }

        for(int i = 0 ; i < n+1 ; i++){
            if(outgoing[i] == 0 && incoming[i] == n-1) return i;
        }
        return -1;
    }
}