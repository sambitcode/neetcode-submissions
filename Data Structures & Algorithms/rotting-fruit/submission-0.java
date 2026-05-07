class Solution {
    public int orangesRotting(int[][] grid) {int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        // Step 1: Count fresh oranges and add rotten oranges to the queue
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) return 0; // No fresh orange

        int minutes = -1;
        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};

        // Step 2: BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            minutes++;  // Each level = 1 minute
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                for (int[] d : directions) {
                    int newRow = pos[0] + d[0];
                    int newCol = pos[1] + d[1];
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        fresh--;
                        queue.add(new int[]{newRow, newCol});
                    }
                }
            }
        }

        return fresh == 0 ? minutes : -1;

    }
}
