class Solution {
    public boolean judgeCircle(String moves) {
        int disUD = 0 , disRL = 0;

        for(int i = 0 ; i < moves.length() ; i++){
            if(moves.charAt(i) == 'U') disUD++;
            else if(moves.charAt(i) == 'R') disRL++;
            else if(moves.charAt(i) == 'L') disRL--;
            else if(moves.charAt(i) == 'D') disUD--;
        }

        // System.out.println(disUD + " " + disRL);

        return disUD == 0 && disRL == 0;
    }
}