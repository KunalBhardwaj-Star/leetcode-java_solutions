class Solution {
    public int totalWaviness(int num1, int num2) {
        int waviness = 0;

        for(int x = num1 ; x <= num2 ; x++){
            String str = "" + x;

            for(int i = 1; i < str.length() - 1; i++){
                if((str.charAt(i) > str.charAt(i-1) && str.charAt(i) > str.charAt(i+1)) || str.charAt(i) < str.charAt(i-1) && str.charAt(i) < str.charAt(i+1))
                    waviness++;
            }
        }

        return waviness;
    }
}