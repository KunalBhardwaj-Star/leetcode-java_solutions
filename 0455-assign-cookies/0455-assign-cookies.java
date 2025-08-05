import java.util.*;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int poiG = 0;
        int poiS = 0;

        while(poiG < g.length && poiS < s.length){
            if(s[poiS] >= g[poiG]){
                poiG ++;
            }
            poiS++;
        }
        return poiG;
    }
}