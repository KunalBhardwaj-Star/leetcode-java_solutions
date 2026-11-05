class Solution {

    private boolean digDiv(int x){

        if(x % 10 == 0)
            return false;

        
        int temp = x;

        while(temp != 0){
            int curr = temp % 10;

            if(curr == 0)
                return false;

            if(x % curr != 0)
                return false;

            temp /= 10;
        }

        return true;
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();

        for(int e = left ; e <= right ; e++){
            if(digDiv(e))
                ans.add(e);
        }

        return ans;
    }
}