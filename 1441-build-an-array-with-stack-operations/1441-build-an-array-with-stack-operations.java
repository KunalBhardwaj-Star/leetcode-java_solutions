class Solution {
    public List<String> buildArray(int[] target, int n) {
        int len = target.length;
        List<String> ans = new ArrayList<>();

        Stack<Integer> st = new Stack<>();

        int i = 0;

        for(int x = 1; x <= n ; x++){

            if(i >= len)
                return ans;

            st.push(i);
            ans.add("Push");

            if(x == target[i])
                i++;

            else{
                st.pop();
                ans.add("Pop");
            }
        }

        return ans;
    }
}