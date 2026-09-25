class Solution {
    public int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int freshCount = 0;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 1) {
                    freshCount++;
                }
                else if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        if (freshCount == 0) {
            return 0;
        }
        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] rotten = queue.poll();
                int r = rotten[0];
                int c = rotten[1];
                int[][] neighbours = { {r - 1, c},{r, c + 1},{r + 1, c},{r, c - 1} };
                for (int[] neighbour : neighbours) {
                    int nr = neighbour[0];
                    int nc = neighbour[1];
                    // rotten , visited , outof bound
                    if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                        continue;
                    }
                    if (grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        freshCount--;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }

            time++;
        }

        if (freshCount == 0) {
            return time - 1;
        }

        return -1;
    }
}
