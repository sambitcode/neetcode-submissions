class Solution {
    public void solve(char[][] board){
        int n = board.length;
        int m = board[0].length;


        // Top & Bottom rows
        for(int i = 0 ; i < m; i++){
            if(board[0][i] == 'O'){
                board[0][i] = '#';
                dfsBetter(board, 0, i);
            }
            if(board[n-1][i] == 'O'){
                board[n-1][i] = '#';
                dfsBetter(board, n-1, i);
            }
        }

        // Left & Right columns
        for(int i = 0 ; i < n; i++){
            if(board[i][0] == 'O'){
                board[i][0] = '#';
                dfsBetter(board, i, 0);
            }
            if(board[i][m-1] == 'O'){
                board[i][m-1] = '#';
                dfsBetter(board, i, m-1);
            }
        }

        // Flip surrounded regions
        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }

        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfsBetter(char[][] board, int row, int col) {
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int n = board.length;
        int m = board[0].length;

        for(int[] dir: dirs){
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if(newRow >= 0 && newRow < n &&
                    newCol >= 0 && newCol < m &&
                    board[newRow][newCol] == 'O'){

                board[newRow][newCol] = '#';
                dfsBetter(board, newRow, newCol);
            }
        }
    }
}
