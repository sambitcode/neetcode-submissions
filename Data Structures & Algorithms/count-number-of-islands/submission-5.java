class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];//space complexity O(n*m)
        int count = 0;
        for(int i = 0 ; i <n ; i++){ //time complexity O(n*m)
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == '1' && visited[i][j] != 1){
                    dfs(i, j, grid, visited, n, m);
                    count++;
                }
            }
        }
        return count;
        //time final - O(n*m) + O(n*m) = O(n*m)
        //space final - O(n*m) + O(n*m) = O(n*m)
    }

    private void dfs(int row, int col, char[][] grid, int[][] visited, int n, int m) {//time complexity O(n*m) for recursion //space complexity O(n*m) for recursive stack
        visited[row][col] = 1;
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

        for(int[] dir: dirs){
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if(newRow >= 0 && newRow < n && newCol>=0 && newCol < m && grid[newRow][newCol] == '1' && visited[newRow][newCol] != 1){
                dfs(newRow, newCol, grid, visited, n, m);
            }
        }
    }
}
