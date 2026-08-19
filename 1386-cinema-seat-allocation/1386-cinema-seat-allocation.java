class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer , Integer> reserved = new HashMap<>();

        for(int[] seat : reservedSeats){
            reserved.put(seat[0],
                reserved.getOrDefault(seat[0] , 0) | (1 << seat[1])
            );
        }

        int ans = (n - reserved.size()) * 2;

        int LFT = (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5);
        int MID = (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7);
        int RGHT = (1 << 6) | (1 << 7) | (1 << 8) | (1 << 9);

        for(int mask : reserved.values()){
            boolean lft = (mask & LFT) == 0;
            boolean mid = (mask & MID) == 0;
            boolean rght = (mask & RGHT) == 0;

            if(lft && rght)
                ans += 2;

            else if(lft || mid || rght)
                ans += 1;
        }

        return ans;
    }
}