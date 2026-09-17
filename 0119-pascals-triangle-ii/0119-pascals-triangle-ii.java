class Solution {
    public List<Integer> getRow(int rowIndex) {
        if(rowIndex == 0)
            return new ArrayList<>(Arrays.asList(1));

        if(rowIndex == 1)
            return new ArrayList<>(Arrays.asList(1 , 1));

        ArrayList<ArrayList<Integer>> pascal = new ArrayList<>();
        pascal.add(new ArrayList<>(Arrays.asList(1)));
        pascal.add(new ArrayList<>(Arrays.asList(1 , 1)));

        for(int i = 2; i <= rowIndex ; i++){
            ArrayList<Integer> curr = new ArrayList<>();

            for(int j = 0 ; j <= i ; j++){
                if(j == 0 || j == i)
                    curr.add(1);

                else{
                    int sum = pascal.get(i-1).get(j-1) + pascal.get(i-1).get(j);
                    curr.add(sum);
                }
            }

            pascal.add(curr);
        }

        return pascal.get(rowIndex);
    }
}