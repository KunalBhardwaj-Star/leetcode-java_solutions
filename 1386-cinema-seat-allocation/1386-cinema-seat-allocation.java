class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer , HashSet<Integer>> reserved = new HashMap<>();

        for(int i = 0 ; i < reservedSeats.length ; i++){
            int row = reservedSeats[i][0];
            int col = reservedSeats[i][1];

            reserved.putIfAbsent(row , new HashSet<>());
            reserved.get(row).add(col);
        }

        int k = reserved.size();

        int ans = (n - k) * 2;

        for (HashSet<Integer> seats : reserved.values()) {

            boolean lft =
                !seats.contains(2) &&
                !seats.contains(3) &&
                !seats.contains(4) &&
                !seats.contains(5);

            boolean mid =
                !seats.contains(4) &&
                !seats.contains(5) &&
                !seats.contains(6) &&
                !seats.contains(7);

            boolean rght =
                !seats.contains(6) &&
                !seats.contains(7) &&
                !seats.contains(8) &&
                !seats.contains(9);

            if (lft && rght)
                ans += 2;
            else if (lft || mid || rght)
                ans += 1;
        }

        return ans;
    }
}