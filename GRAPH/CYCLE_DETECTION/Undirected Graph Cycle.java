class Solution {
    public boolean isCycle(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        boolean[] vis=new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(dfs(adj,vis,i,-1)) return true;
            }
        }
        return false;
    }
    public boolean dfs(ArrayList<ArrayList<Integer>> adj,boolean[] vis,int node,int par){
        vis[node]=true;
        boolean b=false;
        for(int i:adj.get(node)){
            if(vis[i] && i!=par) return true;
            if(!vis[i]){
                b|=dfs(adj,vis,i,node);
            }
        }
        return b;
    }
}
