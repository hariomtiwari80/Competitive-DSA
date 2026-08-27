class Solution {
    public int[][] dp;
    public int longestPalindromeSubseq(String s) {
        dp=new int[s.length()+1][s.length()+1];
        for(int[] a:dp) Arrays.fill(a,-1);
        return solve(s,0,s.length()-1);
    }
    public int solve(String s,int i,int j){
        if(i==j) return 1;
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==s.charAt(j)) return dp[i][j]=2+solve(s,i+1,j-1);
        int t1=solve(s,i+1,j);
        int t2=solve(s,i,j-1);
        return dp[i][j]=Math.max(t1,t2);
    }
}
