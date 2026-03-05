class Solution {
    public int minPartitions(String n) {
        int len = n.length();

        if(len == 1) return n.charAt(0) - '0';

        int left = 0 , right = len-1;

        int max = 0;

        while(left <= right) {
            max = Math.max(max , Math.max(n.charAt(left) - '0' , n.charAt(right) - '0'));
            left ++;
            right --;
        }

        return max;
    }
}