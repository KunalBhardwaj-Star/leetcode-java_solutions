class Solution {
    public boolean canAliceWin(int n) {

        if(n < 10)
            return false;

        boolean alice = true , bob = false;
        int count = 10;

        while(n - count >= 0){
            n -= count;
            count--;

            alice = !alice;
            bob = !bob;
        }

        return !alice;
    }
}