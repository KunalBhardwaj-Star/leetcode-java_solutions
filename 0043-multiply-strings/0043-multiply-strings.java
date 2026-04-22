class Solution {
    public String multiply(String num1, String num2) {
        int x = num1.length() , y = num2.length();

        int[] res = new int[x + y];

        for(int i = x - 1 ; i >= 0 ; i--){
            for(int j = y - 1 ; j >= 0 ; j--){
                int mul = (num1.charAt(i) - '0' ) * (num2.charAt(j) - '0');

                int sum = mul + res[i + j + 1];

                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int num : res){
            if(!(sb.length() == 0 && num == 0)) sb.append(num);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}