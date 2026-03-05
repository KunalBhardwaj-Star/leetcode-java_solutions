class Solution {
    private String generatePoss1(int len){
        String ans1 = "1";

        for(int i = 1 ; i < len ; i++){
            if(ans1.charAt(i-1) == '1')ans1 += "0";
            else ans1 += "1";
        }

        return ans1;
    }

    private String generatePoss2(int len){
        String ans2 = "0";

        for(int i = 1 ; i < len ; i++){
            if(ans2.charAt(i-1) == '1')ans2 += "0";
            else ans2 += "1";
        }

        return ans2;
    }

    public int minOperations(String s) {
        int len = s.length();
        String ans1 = generatePoss1(len) , ans2 = generatePoss2(len);

        int countP1 = 0 , countP2 = 0;

        for(int i = 0 ; i < len ; i++){
            char ch = s.charAt(i);
            if(ans1.charAt(i) != ch) countP1++;
            if(ans2.charAt(i) != ch) countP2++;
        }

        return Math.min(countP1 , countP2);
    }
}