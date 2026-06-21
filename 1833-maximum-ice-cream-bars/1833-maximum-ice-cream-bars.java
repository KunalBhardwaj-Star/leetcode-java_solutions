class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);

        if(costs[0] > coins)
            return 0;

        int curr_sum = 0;
        int i = 0;

        for(i = 0 ; i < costs.length ; i++){
            if(curr_sum + costs[i] > coins)
                return i;

            curr_sum += costs[i];
        }

        return i;
    }
}