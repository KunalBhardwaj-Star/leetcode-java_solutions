class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        int n = citations.length;

        int count = 0;

        for(int i = n - 1; i >= 0 ; i--){
            if(citations[i] >= (n - i))
                count++;
            else 
                break;
        }

        return count;
    }
}