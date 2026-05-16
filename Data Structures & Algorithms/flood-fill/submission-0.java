class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int originalColor = image[sr][sc];
        if(image[sr][sc] == color) return image;
        Queue<int[]> queue = new LinkedList<>(); //space O(n*m)
        queue.offer(new int[]{sr,sc});
        image[sr][sc] = color;
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

        while(!queue.isEmpty()){ //time O(n*m)
            int[] currPos = queue.poll();
            for(int[] dir : dirs){
                int newRow = currPos[0] + dir[0];
                int newCol = currPos[1] + dir[1];
                if(newRow >= 0 && newRow < n && newCol>=0 && newCol < m && image[newRow][newCol] == originalColor && image[newRow][newCol] != color){
                    queue.offer(new int[]{newRow, newCol});
                    image[newRow][newCol] = color;
                }
            }
        }
        return image;
        //time final - O(n*m) = O(n*m)
        //space final - O(n*m) = O(n*m)
    }
}