class Solution {
    public boolean canPartition(int[] arr) {
        int n=arr.length,sum=0;
        for(int x:arr) sum+=x;
        if(sum%2!=0) return false;
        int tar=sum/2;
        int[] dp=new int[tar+1];
        for(int i=arr[0];i<=tar;i++){
            dp[i]=arr[0];
        }
        for(int i=1;i<n;i++){
            for(int j=tar;j>=arr[i];j--){
                dp[j]=Math.max(dp[j],arr[i]+dp[j-arr[i]]);
            }
        }
        for(int i=0;i<=tar;i++){
            if(dp[i]==tar) return true;
        }
        return false;
    }
}
