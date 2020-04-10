// A Java program to print topological sorting of a graph
// using indegrees
import java.util.*;

//Class to represent a graph
class Graph
{
    int V;// No. of vertices

    //An Array of List which contains
    //references to the Adjacency List of
    //each vertex
    List <Integer> adj[];
    public Graph(int V)// Constructor
    {
        this.V = V;
        adj = new ArrayList[V];
        for(int i = 0; i < V; i++)
            adj[i]=new ArrayList<Integer>();
    }

    // function to add an edge to graph
    public void addEdge(int u,int v)
    {
        adj[u].add(v);
    }
    // prints a Topological Sort of the complete graph
    public void topologicalSort()
    {
        // Create a array to store indegrees of all
        // vertices. Initialize all indegrees as 0.
        int indegree[] = new int[V];

        // Traverse adjacency lists to fill indegrees of
        // vertices. This step takes O(V+E) time
        for(int i = 0; i < V; i++)
        {
            ArrayList<Integer> temp = (ArrayList<Integer>) adj[i];
            for(int node : temp)
            {
                indegree[node]++;
            }
        }

        // Create a queue and enqueue all vertices with
        // indegree 0
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0;i < V; i++)
        {
            if(indegree[i]==0)
                q.add(i);
        }

        // Initialize count of visited vertices
        int cnt = 0;

        // Create a vector to store result (A topological
        // ordering of the vertices)
        Vector <Integer> topOrder=new Vector<Integer>();
        while(!q.isEmpty())
        {
            // Extract front of queue (or perform dequeue)
            // and add it to topological order
            int u=q.poll();
            topOrder.add(u);

            // Iterate through all its neighbouring nodes
            // of dequeued node u and decrease their in-degree
            // by 1
            for(int node : adj[u])
            {
                // If in-degree becomes zero, add it to queue
                if(--indegree[node] == 0)
                    q.add(node);
            }
            cnt++;
        }

        // Check if there was a cycle
        if(cnt != V)
        {
            System.out.println("There exists a cycle in the graph");
            return ;
        }

        // Print topological order
        for(int i : topOrder)
        {
            System.out.print(i+" ");
        }
    }
}
