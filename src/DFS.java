import jdk.jshell.Snippet;

import javax.swing.text.GapContent;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class DFS {
    private int vertices;
    private LinkedList<Integer> adj[];

    public DFS(int vertices){
        Scanner scanner = new Scanner(System.in);
        this.vertices = vertices;

        adj = new LinkedList[vertices];
        for(int i = 0; i < vertices; i++){
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w){
        adj[v].add(w);
    }
    public void dfs(int curVertex, Map<Integer, Boolean> visited){
        visited.put(curVertex, true);

        for(Integer neighbour : adj[curVertex]){
            if(!visited.containsKey(neighbour)){
                visited.put(neighbour, true);
                dfs(neighbour, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Boolean> visited = new HashMap<>();
        System.out.print("Enter the number of vertices: ");
        int v = scanner.nextInt();
        System.out.print("Enter the number of edges: ");
        int e = scanner.nextInt();
        DFS g = new DFS(v);

        for(int i = 0; i < e; i++){
            System.out.print("Enter start vertex: ");
            int a = scanner.nextInt();
            System.out.print("Enter end vertex: ");
            int b = scanner.nextInt();
            g.addEdge(a, b);
        }

        System.out.println("Enter the start vertex: ");
        int startIdx = scanner.nextInt();

        g.dfs(startIdx, visited);

        if(visited.size() == g.vertices){
            System.out.println("Connected graph");
        }else{
            System.out.println("Dis-Connected graph");
        }



    }
}
