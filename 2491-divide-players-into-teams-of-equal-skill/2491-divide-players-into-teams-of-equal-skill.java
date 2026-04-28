class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);

        long prod = 0;

        int left = 0 , right = skill.length - 1;
        int sum = skill[left] + skill[right];

        while(left < right){
            if(sum != skill[left] + skill[right]) return -1;
            prod += (skill[left] * skill[right]);
            left ++;
            right--;
        }

        return prod;
    }
}