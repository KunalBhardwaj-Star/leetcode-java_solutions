class Solution {
    private int[] dp;

    private ArrayList<Integer> list;

    private void factorial(int n){
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2 ; i <= n ; i++){
            dp[i] = i * dp[i-1];
        }
    }

    private void createList(int n){
        for(int i = 1 ; i <= n ; i++){
            list.add(i);
        }
    }

    private String getKthPermutation(int n , int k){
        if(k > dp[n])
            return "";

        StringBuilder sb = new StringBuilder();

        int remLen = n;

        while(remLen > 0){
            for(int x : list){
                int blockSize = dp[remLen - 1];

                if(k > blockSize)
                    k -= blockSize;

                else {
                    sb.append("" + x);
                    list.remove(Integer.valueOf(x));
                    remLen--;
                    break;
                }
            }
        }

        return sb.toString();
    }

    public String getPermutation(int n, int k) {
        dp = new int[n+1];
        list = new ArrayList<>();
        factorial(n);
        createList(n);
        return getKthPermutation(n , k);
    }
}