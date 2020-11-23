/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG
{ 
    private int V;   // No. of vertices 
    private LinkedList<Integer> adj[]; //Adjacency Lists 
  
    // Constructor 
    GFG(int v) 
    { 
        V = v; 
        adj = new LinkedList[v]; 
        for (int i=0; i<v; ++i) 
            adj[i] = new LinkedList(); 
    } 
       void addEdge(int source,int destination){
        adj[source].add(destination);
        adj[destination].add(source);
    }
    public int bfs(int source,int destination){
    boolean visited[]=new boolean[adj.length];
    int parent[]=new int[adj.length];
    Queue<Integer>q=new LinkedList<>();
    q.add(source);
    parent[source]=-1;
    visited[source]=true;
   // int curr=destination;
    while(!q.isEmpty()){
        int curr = q.poll();
        if(curr==destination)break;
        for(int neighbour:adj[curr]){
            if(!visited[neighbour]){
                visited[neighbour]=true;
                q.add(neighbour);
                parent[neighbour]=curr;
                }
            }
        }
        int cur=destination;
        int dis=0;
        while(parent[cur]!=-1){
            System.out.println(cur+" -> ");
            cur=parent[cur];
            dis++;
        }
        return dis;
    }

    
	public static void main (String[] args) {
	    Scanner in=new Scanner(System.in);
	    
	    int v=in.nextInt();
	    int e=in.nextInt();
	    GFG c=new GFG(v);
	    System.out.println("Enter Edge : ");
	    for(int i=0; i<e; i++){
	        int source=in.nextInt();
	        int destination=in.nextInt();
	       c.addEdge(source,destination);
	    }
	    int source=in.nextInt();
	    int destination=in.nextInt();
	    int r=c.bfs(source,destination);
	    System.out.println("Distance : "+r);
	    
	}
}