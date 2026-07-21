class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        String form = "1" + s + "1";

        int len = form.length();

        int oneCount = 0;
        int start = 0;
        int end = 1;

        for(int i = 1 ; i < len - 1 ; i++){
            if(form.charAt(i) == '1')
                oneCount++;
        }

        ArrayList<String> list = new ArrayList<>();

        for(end = 1; end < len ; end++){
            if(form.charAt(end - 1) != form.charAt(end)){
                list.add(form.substring(start , end));
                start = end;
            }
        }

        int maxZeroSurr = 0;

        for(int i = 1 ; i < list.size() - 1 ; i ++){
            if(list.get(i-1).contains("0") && list.get(i+1).contains("0")){
                int curr = list.get(i-1).length() + list.get(i+1).length();
                maxZeroSurr = Math.max(maxZeroSurr , curr);
            }
        }

        return maxZeroSurr == 0 ? oneCount : maxZeroSurr + oneCount;
    }
}