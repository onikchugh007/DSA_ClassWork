class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++)
            adj.add(new ArrayList<>());

        for(int arr[] : prerequisites)
            adj.get(arr[1]).add(arr[0]);
        
        boolean vis[] = new boolean[numCourses];
        boolean path[] = new boolean[numCourses];
        boolean flag = true;
        for(int i=0;i<numCourses;i++)
        {
            if(!vis[i] && dfs(adj,vis,path,i))flag = false;
        }
        if(!flag)return new int[]{};
        int topo[] = new int[numCourses];
        int indegree[] = new int[numCourses];

        for(int i=0;i<numCourses;i++)
        {
            for(int n : adj.get(i))
                indegree[n]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i]==0)queue.add(i);
        }
        int i=0;
        while(!queue.isEmpty())
        {
            int node = queue.poll();
            topo[i++]=node;

            for(int n : adj.get(node))
            {
                indegree[n]--;
                if(indegree[n]==0)queue.add(n);
            }
        }
        return topo;
    }
    boolean dfs(List<List<Integer>> adj,boolean vis[],boolean path[],int node)
    {
        vis[node]=path[node]=true;

        for(int next : adj.get(node))
        {
            if(!vis[next] && dfs(adj,vis,path,next))return true;
            else if(path[next])return true;
        }
        path[node] = false;
        return false;
    }
}
