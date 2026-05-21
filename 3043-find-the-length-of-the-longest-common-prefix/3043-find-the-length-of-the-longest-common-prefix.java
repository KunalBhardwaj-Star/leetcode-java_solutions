class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<String> hs = new HashSet<>();

        for(int i = 0 ; i < arr1.length ; i++){
            String curr = "" + arr1[i];
            String prefix = "";

            for(char ch : curr.toCharArray()){
                prefix += ch;
                hs.add(prefix);
            }
        }

        int max = 0;

        for(int i = 0 ; i < arr2.length ; i++){
            String curr = "" + arr2[i];
            String prefix = "";

            for(char ch : curr.toCharArray()){
                prefix += ch;

                if(hs.contains(prefix)){
                    max = Math.max(max , prefix.length());
                }
            }
        }

        return max;
    }
}