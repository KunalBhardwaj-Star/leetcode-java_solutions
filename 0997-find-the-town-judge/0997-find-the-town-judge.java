class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n <= 1 && trust.length == 0) return  1;
        int[] score = new int[n+1];

        for(int i = 0 ; i < trust.length; i++){
            score[trust[i][0]]--;
            score[trust[i][1]]++;
        }

        for(int i = 0 ; i < n+1; i++){
            if(score[i] == n-1) return i;
        }

        return -1;
    }
}