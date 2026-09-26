class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String , String> map = new HashMap<>();

        for(List<String> curr : knowledge){
            map.put(curr.get(0) , curr.get(1));
        }

        boolean open = false;

        String ans = "" , dummy = "";

        for(char ch : s.toCharArray()){

            if(open && ch == ')'){
                ans += map.containsKey(dummy) ? map.get(dummy) : '?';
                dummy = "";
                open = false;
            }

            else if(ch == '('){
                open = true;
            }

            else if(open){
                dummy += ch;
            }

            else{
                ans += ch;
            }
        }

        return ans;
    }
}