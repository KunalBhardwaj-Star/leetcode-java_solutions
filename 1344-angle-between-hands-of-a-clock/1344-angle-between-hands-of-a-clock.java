class Solution {
    public double angleClock(int hour, int minutes) {
        HashMap<Integer , Integer> hrs = new HashMap<>();
        hrs.put(1 , 30);
        hrs.put(2 , 60);
        hrs.put(3 , 90);
        hrs.put(4 , 120);
        hrs.put(5 , 150);
        hrs.put(6 , 180);
        hrs.put(7 , 210);
        hrs.put(8 , 240);
        hrs.put(9 , 270);
        hrs.put(10 , 300);
        hrs.put(11 , 330);
        hrs.put(12, 0);
        double hr = hrs.get(hour) + 0.5 * minutes > 360 ? 360 - (hrs.get(hour) + 0.5 * minutes) : hrs.get(hour) + 0.5 * minutes;
        double min = minutes == 60 ? 0 : minutes * 6;

        double ans = Math.abs(hr - min);

        return ans > 180 ? 360 - ans : ans;
    }
}