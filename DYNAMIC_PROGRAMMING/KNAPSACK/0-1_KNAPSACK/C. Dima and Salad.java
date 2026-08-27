
import java.util.*;
public class Main {
    public static int offset=100000;
    public static int[][] dp;
    public static int t;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[] pro=new int[n];
        for(int i=0;i<n;i++) pro[i]=sc.nextInt();
        int[] cal=new int[n];
        for(int i=0;i<n;i++) cal[i]=sc.nextInt();
        dp=new int[n+1][2*offset+1];
        t=k;
        for(int[] a:dp) Arrays.fill(a,-1);
        int ans=find(pro,cal,0,0);
        if(ans==0) System.out.print(-1);
        else System.out.print(ans);
    }
    public static int find(int[] pro,int[] cal,int i,int diff){
        if(i==pro.length){
            if(diff==0) return 0;
            else return -10000;
        }
        if(dp[i][diff+offset]!=-1) return dp[i][diff+offset];
        int skip=find(pro,cal,i+1,diff);
        int take=pro[i]+find(pro,cal,i+1,diff+(t*cal[i]-pro[i]));
        return dp[i][diff+offset]=Math.max(take,skip);
    }
}
