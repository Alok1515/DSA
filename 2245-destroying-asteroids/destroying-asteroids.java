class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {

        int n = asteroids.length;

        Arrays.sort(asteroids);

        long currMass = mass;

        for(int asteroid : asteroids) {
            if(asteroid > currMass) return false;

            currMass += asteroid;
        }

        return true;
    }
}