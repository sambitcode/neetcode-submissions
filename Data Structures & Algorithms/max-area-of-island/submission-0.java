class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 1 && !visited[i][j]) {
                    int area = dfsOnly(grid, i, j, visited, n, m);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private int dfsOnly(int[][] grid, int i, int j,
                        boolean[][] visited,
                        int n, int m) {
        if (i < 0 || i >= n || j < 0 || j >= m ||
                grid[i][j] == 0 || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        int area = 1;
        area += dfsOnly(grid, i + 1, j, visited, n, m);
        area += dfsOnly(grid, i - 1, j, visited, n, m);
        area += dfsOnly(grid, i, j + 1, visited, n, m);
        area += dfsOnly(grid, i, j - 1, visited, n, m);
        return area;
    }
}
