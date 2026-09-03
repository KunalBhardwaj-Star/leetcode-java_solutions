class Solution {
    public String countAndSay(int n) {
        if(n == 1)
            return "1";

        StringBuilder ans = new StringBuilder();

        ans.append("11");

        for(int i = 3 ; i <= n ; i++){
            StringBuilder curr = new StringBuilder();

            int lft = 0 , rght = 0;
            while(rght < ans.length()){
                if(ans.charAt(lft) != ans.charAt(rght)){
                    curr.append(rght - lft);
                    curr.append(ans.charAt(lft));

                    lft = rght;
                }

                rght++;
            }

            curr.append(rght - lft);
            curr.append(ans.charAt(lft));

            ans = curr;
        }

        return ans.toString();
    }
}