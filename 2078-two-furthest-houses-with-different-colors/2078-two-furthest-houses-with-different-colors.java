class Solution {
    public int maxDistance(int[] colors) {
        int len = colors.length;
        
        int leftL = 0 , rightL = len - 1 , ansL = -1;

        while(leftL < rightL){
            if(colors[rightL] != colors[leftL]){
                ansL = rightL - leftL;
                break;
            }

            rightL--;
        }

        int leftR = 0 , rightR = len - 1 , ansR = -1;


        while(leftR < rightR){
            if(colors[rightR] != colors[leftR]){
                ansR = rightR - leftR;
                break;
            }

            leftR++;
        }

        return Math.max(ansR , ansL);
    }
}