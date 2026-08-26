class Solution {
    public Boolean[][] dp;
    public boolean canPartition(int[] arr) {
        int sum=0;
        for(int x:arr) sum+=x;
        if(sum%2!=0) return false;
        dp=new Boolean[sum+1][arr.length+1];
        return solve(arr,0,sum/2,0);
    }
    public boolean solve(int[] arr,int s,int half,int i){
        if(i==arr.length){
            if(s==half) return true;
            return false;
        }
        if(s>half) return false;
        if(dp[s][i]!=null) return dp[s][i];
        boolean b1=solve(arr,s+arr[i],half,i+1);
        boolean b2=solve(arr,s,half,i+1);
        return dp[s][i]=b1 || b2;
    }
}
