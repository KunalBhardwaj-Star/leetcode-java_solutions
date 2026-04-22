class Solution {
    private boolean isEditable(String q , String d){
        if(q.equals(d)) return true;
        if(q.length() != d.length()) return false;

        int count = 0;

        for(int i = 0 ; i < q.length() ; i++){
            if(q.charAt(i) != d.charAt(i)) count++;
        }

        return count <= 2;
    }
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        int qLen = queries.length , dLen = dictionary.length;

        List<String> ans = new ArrayList<>();

        for(int i = 0 ; i < qLen ; i++){
            for(int j = 0 ; j < dLen ; j++){
                if(isEditable(queries[i] , dictionary[j])){
                    ans.add(queries[i]);
                    break;
                }
            }
        }

        return ans;
    }
}