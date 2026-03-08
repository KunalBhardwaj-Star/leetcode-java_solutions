import java.util.*;

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums[0].length();
        Set<Integer> seen = new HashSet<>();
        
        // 1. Convert all binary strings to Integers and store in a Set
        for (String s : nums) {
            seen.add(Integer.parseInt(s, 2));
        }
        
        // 2. Check every number from 0 to 2^n
        for (int i = 0; i <= n; i++) { // You only need to check up to n+1 to find one
            if (!seen.contains(i)) {
                // 3. Convert back to binary
                String res = Integer.toBinaryString(i);
                
                // 4. IMPORTANT: Manually pad with leading zeros to match length 'n'
                while (res.length() < n) {
                    res = "0" + res;
                }
                return res;
            }
        }
        return "";
    }
}