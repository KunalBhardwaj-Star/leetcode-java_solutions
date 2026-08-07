class Solution {
    public String smallestNumber(String num, long t) {
        long remainingFactor = t;

        for(int factor = 2; factor <= 9 ; factor++){
            while(remainingFactor % factor == 0)
                remainingFactor /= factor;
        }

        if(remainingFactor > 1)
            return "-1";

        int len = num.length();

        long[] requiredFactor = new long[len + 1];
        requiredFactor[0] = t;

        int firstZeroIdx = len - 1;

        char[] dig = num.toCharArray();

        for(int i = 0 ; i < len ; i++){
            if(dig[i] == '0'){
                firstZeroIdx = i;
                break;
            }

            requiredFactor[i + 1] = requiredFactor[i] / gcd(requiredFactor[i] , dig[i] - '0');
        }

        if(requiredFactor[len] == 1)
            return num;

        for(int i = firstZeroIdx ; i >= 0 ; i--){
            while(++dig[i] <= '9'){
                long need = requiredFactor[i] / gcd(requiredFactor[i] , dig[i] - '0');

                int candDig = 9;

                for(int j = len - 1; j > i ; j--){
                    while(need % candDig != 0)
                        candDig--;

                    need /= candDig;

                    dig[j] = (char)('0' + candDig);
                }

                if(need == 1){
                    return new String(dig);
                }
            }
        }

        StringBuilder ans = new StringBuilder();

        long remaining = t;

        for(int digit = 9 ; digit >= 2 ; digit--){

            while(remaining % digit == 0){
                ans.append((char)('0' + digit));
                remaining /= digit;
            }
        }

        int extra = Math.max(len + 1 - ans.length() , 0);

        while(extra-- > 0){
            ans.append('1');
        }

        return ans.reverse().toString();
    }

    private long gcd(long first , long second){
        while(second != 0){
            long temp = second;
            second = first % second;
            first = temp;
        }

        return first;
    }
}