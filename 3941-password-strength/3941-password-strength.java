class Solution {
    public int passwordStrength(String password) {
        int strength = 0;

        boolean [] seen = new boolean[128];

        for(char ch : password.toCharArray()){
            if(seen[ch]) 
                continue;

            seen[ch] = true;

            if(ch >= 'a' && ch <= 'z')
                strength += 1;

            else if(ch >= 'A' && ch <= 'Z')
                strength += 2;

            else if(ch >= '0' && ch <= '9')
                strength += 3;

            else
                strength += 5;
        }

        return strength;
    }
}