class LeetCode1319 {

    class DSU {
        int[] parent;
        int[] rank;
        int component;

        DSU(int n) {
            parent = new int[n];
            for (int i=0;i<n;i++) {
                parent[i] = i;
            }
            rank = new int[n];
            component = n;
        }

        public int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        public void union(int x, int y) {
            int xr = find(x), yr = find(y);

            if (xr == yr){
                return;
            } else if (rank[xr] > rank[yr]) {
                component--;
                parent[yr] = xr;
            } else if (rank[xr] < rank[yr]) {
                component--;
                parent[xr] = yr;
            } else {
                component--;
                parent[yr] = xr;
                rank[xr]++;
            }
        }

   }
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n-1) return -1;
        DSU dsu = new DSU(n);

        for (int i=0;i<connections.length;i++) {
            dsu.union(connections[i][0], connections[i][1]);
        }
        return dsu.component-1;

    }
}
