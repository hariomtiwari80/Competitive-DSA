class Solution {
    public List<Integer> largestDivisibleSubset(int[] arr) {
        List<Integer> ans=new ArrayList<>();
        int n=arr.length;
        if(n==1){
            ans.add(arr[0]);
            return ans;
        }
        int[] dp=new int[n];
        int[] idx=new int[n];
        Arrays.sort(arr);
        Arrays.fill(dp,1);
        Arrays.fill(idx,-1);
        int maxidx=-1;
        for(int i=1;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if((arr[i]%arr[j]==0)){
                    if(dp[j]+1>dp[i]){
                        dp[i]=1+dp[j];
                        idx[i]=j;
                    }
                }
            }
            if(maxidx==-1 || dp[i]>dp[maxidx]) maxidx=i;
        }
        while(maxidx!=-1){
            ans.add(arr[maxidx]);
            maxidx=idx[maxidx];
        }
        return ans;
    }
}
