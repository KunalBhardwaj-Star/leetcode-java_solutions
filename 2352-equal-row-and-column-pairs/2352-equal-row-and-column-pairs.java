class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;

        HashMap<List<Integer> , Integer> map = new HashMap<>();

        for(int i = 0 ; i < n ; i++){
            List<Integer> curr = new ArrayList<>();
            for(int j = 0 ; j < n ; j++){
                curr.add(grid[i][j]);
            }

            map.put(curr , map.getOrDefault(curr , 0) + 1);
        }

        int count = 0;

        // map.forEach((key, value) -> {
        //     System.out.println("Key: " + Arrays.toString(key) + " | Value: " + value);
        // });

        for(int i = 0 ; i < n ; i++){
            List<Integer> c = new ArrayList<>();
            for(int j = 0 ; j < n ; j++){
                c.add(grid[j][i]);
            }

            count += map.containsKey(c) ? map.get(c) : 0;
        }

        return count;
        
    }
}