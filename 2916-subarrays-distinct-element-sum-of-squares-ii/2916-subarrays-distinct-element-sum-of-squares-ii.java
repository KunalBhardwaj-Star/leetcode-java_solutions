class Solution {

    long MOD = 1_000_000_007L;

    long[] sq;
    long[] sum;
    long[] lazy;

    int n;

    public int sumCounts(int[] nums) {
        n = nums.length;

        sq = new long[4 * n];
        sum = new long[4 * n];
        lazy = new long[4 * n];

        int[] last = new int[100001];

        Arrays.fill(last , -1);

        long ans = 0;

        for(int i = 0 ; i < n ; i++){
            int x = nums[i];

            int prev = last[x];

            update(1 , 0 , n-1 , prev + 1 , i);

            ans = (ans + sq[1]) % MOD;

            last[x] = i;
        }

        return (int)ans;
    }

    private void push(int node , int start , int end){
        if(lazy[node] == 0) return;

        long val = lazy[node];
        long len = end - start + 1;

        sq[node] = (sq[node] + 2 * val * sum[node] + val * val % MOD * len) % MOD;

        sum[node] = (sum[node] + val * len) % MOD;

        if(start != end){
            lazy[2 * node] = (lazy[node * 2] + val) % MOD;
            lazy[node * 2 + 1] = (lazy[node * 2 + 1] + val) % MOD;
        }

        lazy[node] = 0;
    }

    private void update(int node , int start , int end , int l , int r){
        push(node , start , end);

        if(start > r || end < l)
            return;

        if(l <= start && end <= r){
            long len = end - start + 1;

            sq[node] = (sq[node] + 2*sum[node] + len) % MOD;
            sum[node] = (sum[node] + len) % MOD;

            if(start != end){
                lazy[2 * node] ++;
                lazy[2 * node] %= MOD;
                lazy[2 * node + 1]++;
                lazy[2 * node + 1] %= MOD;
            }

            return;
        }

        int mid = start + (end - start) / 2;

        update(node * 2 , start , mid , l , r);
        update(node * 2 + 1 , mid + 1 , end , l , r);

        sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
        sq[node] = (sq[node * 2] + sq[node * 2 + 1]) % MOD;
    }
}