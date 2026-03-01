class Solution {
    public int minPartitions(String n) {
        if(n.length() == 1) return n.charAt(0) - '0';
        int max = 0;

        int left = 0 , right = n.length() - 1;

        while(left <= right){
            max = Math.max(max , Math.max(n.charAt(left) - '0' , n.charAt(right) - '0'));
            left++;
            right--;
        }

        return max;
    }
}