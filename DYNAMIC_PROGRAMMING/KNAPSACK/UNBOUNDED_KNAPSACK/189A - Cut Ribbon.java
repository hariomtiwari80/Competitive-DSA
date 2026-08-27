package Infosys;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[3];
        for(int i=0;i<3;i++) arr[i]=sc.nextInt();
        int[] dp=new int[n+1];
        Arrays.fill(dp,Integer.MIN_VALUE);
        dp[0]=0;
        for(int i=0;i<3;i++){
            for(int j=arr[i];j<=n;j++){
                if(dp[j-arr[i]]!=Integer.MIN_VALUE) dp[j]=Math.max(dp[j],1+dp[j-arr[i]]);
            }
        }
        if(dp[n]==Integer.MIN_VALUE) System.out.print(-1);
        else System.out.print(dp[n]);
    }
}
