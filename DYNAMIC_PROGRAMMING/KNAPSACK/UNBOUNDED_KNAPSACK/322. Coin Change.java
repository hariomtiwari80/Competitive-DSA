class Solution {
    public int coinChange(int[] arr, int amt) {
        int n=arr.length;
        int[] dp=new int[amt+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=0;i<n;i++){
            for(int j=arr[i];j<=amt;j++){
                if(dp[j-arr[i]]!=Integer.MAX_VALUE) dp[j]=Math.min(dp[j],1+dp[j-arr[i]]);
            }
        }
        if(dp[amt]==Integer.MAX_VALUE) return -1;
        return dp[amt];
    }
}
