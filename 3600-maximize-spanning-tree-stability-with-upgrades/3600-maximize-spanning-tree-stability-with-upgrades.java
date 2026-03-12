import java.util.*;

class Solution {
    class DSU {
        int[] parent;
        int components;

        public DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
            components = n;
        }

        public int find(int i) {
            if (parent[i] == i) return i;
            return parent[i] = find(parent[i]);
        }

        public boolean union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                parent[rootI] = rootJ;
                components--;
                return true;
            }
            return false;
        }
    }

    public int maxStability(int n, int[][] edges, int k) {
        // First, check if a spanning tree is even possible using ALL mandatory edges
        // and check if they already violate the acyclic property.
        DSU checkST = new DSU(n);
        int mandatoryCount = 0;
        for (int[] e : edges) {
            if (e[3] == 1) {
                if (!checkST.union(e[0], e[1])) return -1; // Mandatory edges form a cycle
                mandatoryCount++;
            }
        }

        int low = 1, high = 2000000; // max strength is 10^6, upgraded is 2*10^6
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canFormMST(n, edges, k, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private boolean canFormMST(int n, int[][] edges, int k, int threshold) {
        DSU dsu = new DSU(n);
        int upgradesUsed = 0;

        // 1. Mandatory edges must be >= threshold
        for (int[] e : edges) {
            if (e[3] == 1) {
                if (e[2] < threshold) return false;
                dsu.union(e[0], e[1]);
            }
        }

        // 2. Add optional edges that are already strong enough (Cost: 0 upgrades)
        for (int[] e : edges) {
            if (e[3] == 0 && e[2] >= threshold) {
                dsu.union(e[0], e[1]);
            }
        }

        // 3. Add optional edges that become strong enough after upgrade (Cost: 1 upgrade)
        for (int[] e : edges) {
            if (e[3] == 0 && e[2] < threshold && e[2] * 2 >= threshold) {
                if (upgradesUsed < k) {
                    if (dsu.union(e[0], e[1])) {
                        upgradesUsed++;
                    }
                }
            }
        }

        return dsu.components == 1;
    }
}