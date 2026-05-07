class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        int result = 0;
        for(int i = 0 ; i <n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(visited[i][j] != 1 && grid[i][j] == '1'){
                    numIslandsDfs(grid, i, j, visited, n, m);
                    result++;
                }
            }
        }
        return result;
    }

    private void numIslandsDfs(char[][] grid, int i, int j, int[][] visited, int n , int m) {
        visited[i][j] = 1;
        int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        for(int[] dir : dirs){
            int newRow = i + dir[0];
            int newCol = j + dir[1];
            if(newRow>=0 && newRow<n && newCol>=0 && newCol< m && grid[newRow][newCol] == '1' && visited[newRow][newCol] != 1){
                numIslandsDfs(grid, newRow, newCol, visited, n, m);
            }
        }
    }
}
