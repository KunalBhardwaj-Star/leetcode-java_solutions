class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);

        long currMass = mass;

        for (int ast : asteroids) {
            if (currMass < ast) {
                return false;
            }

            currMass += ast;
        }

        return true;
    }
}