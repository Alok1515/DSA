class Solution {

    private int findFinishTime(int[] start1, int[] duration1, int[] start2, int[] duration2) {

        int finish1 = Integer.MAX_VALUE;
        for (int i = 0; i < start1.length; i++) {
            finish1 = Math.min(finish1, start1[i] + duration1[i]);
        }

        int finish2 = Integer.MAX_VALUE;
        for (int i = 0; i < start2.length; i++) {
            finish2 = Math.min(finish2, Math.max(finish1, start2[i]) + duration2[i]);
        }

        return finish2;
    }

    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int pehleLand_FirWater = findFinishTime(landStartTime, landDuration, waterStartTime, waterDuration);

        int pehleWater_FirLand = findFinishTime(waterStartTime, waterDuration, landStartTime, landDuration);

        return Math.min(pehleLand_FirWater, pehleWater_FirLand);
    }
}