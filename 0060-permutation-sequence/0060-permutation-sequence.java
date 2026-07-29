class Solution {
    private ArrayList<Integer> list;
    private int[] fact;

    private void factorial(int n){
        fact = new int[n+1];
        fact[0] = 1;
        fact[1] = 1;

        for(int i = 2; i <= n; i++){
            fact[i] = i * fact[i-1];
        }
    }

    private String getKthPermutation(int n , int k){
        if(k > fact[n])
            return "";

        int requiredLen = n;

        StringBuilder sb = new StringBuilder();

        while(requiredLen > 0){
            for(int x : list){
                if(fact[requiredLen - 1] < k){
                    k -= fact[requiredLen - 1];
                } else {
                    sb.append("" + x);
                    list.remove(Integer.valueOf(x));
                    requiredLen--;
                    break;
                }
            }
        }

        return sb.toString();
    }

    public String getPermutation(int n, int k) {
        list = new ArrayList<>();

        for(int i = 1 ; i <= n ; i++){
            list.add(i);
        }

        factorial(n);

        return getKthPermutation(n , k);
    }
}