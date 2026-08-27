class Solution {
    public int change(int amt, int[] arr) {
        int n=arr.length;
        int[] dp=new int[amt+1];
        dp[0]=1;
        for(int i=0;i<n;i++){
            for(int j=arr[i];j<=amt;j++){
                dp[j]+=dp[j-arr[i]];
            }
        }
        return dp[amt];
    }
}
