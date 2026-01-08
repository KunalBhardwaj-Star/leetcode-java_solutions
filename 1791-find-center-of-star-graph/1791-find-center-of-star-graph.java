class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length;
        int[] score = new int[n+2];

        for(int i = 0 ; i < n ; i++){
            score[edges[i][0]]++;
            score[edges[i][1]]++;
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < n+2 ; i++){
            max = score[i] > max ? i : max;
        }

        return max;
    }
}