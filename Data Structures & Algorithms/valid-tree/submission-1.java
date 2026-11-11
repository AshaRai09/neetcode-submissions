class Solution {

    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        dfs(0, adj, visited);
        for (int i = 0; i < n; i++) {

            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }

    private void dfs(int node,
                     ArrayList<ArrayList<Integer>> adj,
                     boolean[] visited) {

        visited[node] = true;

        for (int neighbor : adj.get(node)) {

            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited);
            }
        }
    }
}