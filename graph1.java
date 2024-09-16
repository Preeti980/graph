import java.util.*;
public class g2 {
 static class Edge{
    int src;
    int dest;
    int wt;
    public Edge(int s, int d , int w){
this.src= s;
this.dest = d;
this.wt= w;
    }
}
    public static void main(String args[]) {
     
        int v =5;
        ArrayList<Edge>[] graph = new ArrayList[v]; // null->empty arraylist
        for(int i=0;i<v;i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,5)); // 0 -vertex
        //1 - vertex
        graph[1].add(new Edge(1,0,5));
        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,3));
        //2 - vertex
        graph[2].add(new Edge(2,1,1));
        graph[2].add(new Edge(2,3,1));
        graph[2].add(new Edge(1,4,4));
        //3 - vertex
        graph[3].add(new Edge(3,1,3));
        graph[3].add(new Edge(3,2,1));
     
        //4 - vertex
        graph[4].add(new Edge(4,2,2));
        
       //2's neighbors
       for(int i=0;i<graph[2].size();i++){
        Edge e = graph[2].get(i);//src,dest,wt
        System.out.println(e.dest);
       } 
    }
}

//bfs 
import java.util.*;

public class g2 {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 1)); // 0 -vertex here waight is 1 means no weight given
        // 1 - vertex
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 1));
        // 2 - vertex
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(1, 4, 1));
        // 3 - vertex
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 2, 1));

        // 4 - vertex
        graph[4].add(new Edge(4, 2, 1));

    }

    public static void bfs(ArrayList<Edge>[] graph) {
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[graph.length];
        q.add(0);
        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!vis[curr]) {
                System.out.print(curr + " ");
                vis[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void main(String args[]) {

        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v]; // null->empty arraylist
        createGraph(graph);
        bfs(graph);

    }
}
//dfs
public  static void dfs(ArrayList<Edge>[] graph,int curr, boolean vis[]){
//visit
System.out.print(curr+" ");
vis[curr] = true;
for(int i=0;i<graph[curr].size();i++){
Edge e= graph[curr].get(i);
if(!vis[e.dest]){
    dfs(graph,e.dest,vis);
} 
}
}
// has path
public static boolean hasPath(ArrayList<Edge>[] graph,int src, int dest,  boolean vis[]){
    if(src == dest){
        return true;
    }
    vis[src] = true;
    for(int i=0;i<graph[src].size();i++){
        Edge e = graph[src].get(i);
        if(!vis[e.dest] && hasPath(graph, e.dest, dest, vis)){
            return true;
        }
    }
    return false;
 }
    public static void main(String args[]) {

        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v]; // null->empty arraylist
        createGraph(graph);
    System.out.print(hasPath(graph, 0, 2, new boolean[v]));

    }
}
