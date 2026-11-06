class Solution {
    public String getPermutation(int n, int k) {
        int[] fact = new int[n+1];
        fact[0] = fact[1] = 1;

        for(int i = 2; i <=n ; i++){
            fact[i] = fact[i-1] * i;
        }

        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 1; i <= n ; i++)
            list.add(i);

        StringBuilder sb = new StringBuilder();

        for(int remaining = n ; remaining > 0 ; remaining--){
            int idx = (k-1) / fact[remaining - 1];
            sb.append(list.remove(idx));
            k = (k - 1) % fact[remaining - 1] + 1;
        }

        return sb.toString();
    }
}