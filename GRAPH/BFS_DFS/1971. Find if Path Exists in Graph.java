class Solution {
    public boolean validPath(int n, int[][] edges, int src, int des) {

        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        boolean[] vis=new boolean[n];
        return dfs(adj,vis,src,des);
    }
    public boolean dfs(List<List<Integer>> adj,boolean[] vis,int node,int des){
        vis[node]=true;
        if(node==des) return true;
        boolean b=false;
        for(int i:adj.get(node)){
            if(!vis[i]) b|=dfs(adj,vis,i,des);
        }
        return b;
    }
}
