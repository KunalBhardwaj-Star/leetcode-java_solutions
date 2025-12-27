class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length(), curr = 0 , idx = 0; 
        for(int i = 0 ; i < n ; i++){ 
            if(customers.charAt(i) == 'Y') curr += 1; 
        } 
        int minPenalty = curr;
        for(int i = 1 ; i <= n; i++){
            curr = customers.charAt(i-1) == 'Y' ? curr - 1 : curr + 1; 
            if(minPenalty > curr) {
                minPenalty = curr;
                idx = i;
            }
        } 
        return idx;
    }
}