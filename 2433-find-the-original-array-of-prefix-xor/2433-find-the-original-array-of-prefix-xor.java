class Solution {
    public int[] findArray(int[] pref) {
        int len = pref.length;

        if(len == 1)
            return pref;

        int[] ans = new int[len];

        ans[0] = pref[0];

        for(int i = 1; i < len ; i++){
            ans[i] = pref[i] ^ pref[i-1];
        }

        return ans;
    }
}