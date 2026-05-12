class Solution {
    /*public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        char[] text1Char = text1.toCharArray();
        char[] text2Char = text2.toCharArray();
        int[][] dp = new int[n][m];
        for(int[] ar : dp){
            Arrays.fill(ar, -1);
        }
        return longCalRec(text1Char, text2Char, dp,n-1, m-1);
    }

    private int longCalRec(char[] text1Char, char[] text2Char, int[][] dp, int index1, int index2) {
        if(index1 < 0 || index2 < 0) return 0;
        if(dp[index1][index2] != -1) return dp[index1][index2];
        if(text1Char[index1] == text2Char[index2]){
            return dp[index1][index2] = 1 + longCalRec(text1Char, text2Char, dp, index1-1, index2-1);
        }
        return dp[index1][index2] =Math.max(longCalRec(text1Char, text2Char, dp,index1-1, index2),
                longCalRec(text1Char, text2Char, dp, index1, index2-1)
        );
    }*/

    /*public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        char[] text1Char = text1.toCharArray();
        char[] text2Char = text2.toCharArray();
        int[][] dp = new int[n+1][m+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(text1Char[i-1] == text2Char[j-1]){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] =Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }*/

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        char[] text1Char = text1.toCharArray();
        char[] text2Char = text2.toCharArray();
        int[] dp = new int[m+1];
        for(int i = 1; i <= n; i++){
            int[] temp = new int[m+1];
            for(int j = 1; j <= m; j++){
                if(text1Char[i-1] == text2Char[j-1]){
                    temp[j] = 1 + dp[j-1];
                } else {
                    temp[j] =Math.max(dp[j], temp[j-1]);
                }
            }
            dp = temp;
        }
        return dp[m];
    }
}
