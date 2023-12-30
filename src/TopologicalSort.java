import java.util.*;

public class TopologicalSort{
    private final int vertices;
    private int edges;

    // maintain adjancy list
    private final LinkedList<Integer>[] adj;

    public TopologicalSort(int vertices){
        this.vertices = vertices;
        adj = new LinkedList[vertices+1];
        for(int i = 1; i <= vertices; i++){
            adj[i] = new LinkedList<>();
        }
    }

     private void addEdge(int v, int w){
        adj[v].push(w);
    }

    void dfs(int curVertex, Map<Integer, Boolean> visited, Stack<Integer> stack){
        visited.put(curVertex, true);

        for(Integer neighbour : adj[curVertex]){
            if(!visited.containsKey(neighbour)){
                dfs(neighbour, visited, stack);
            }
        }

        stack.push(curVertex);
        return;
    }

    void topologicalSort(int curVertex){
        Map<Integer, Boolean> visited = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for(int i = 1; i <= vertices; i++){
            if(!visited.containsKey(i)){
                dfs(i, visited, stack);
            }
        }

        System.out.println("The topological order is: ");
        while(!stack.empty()){
            System.out.print(stack.pop() + " ");
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        int v = scanner.nextInt();

        System.out.println("Enter the number of edges");
        int e = scanner.nextInt();

        TopologicalSort g = new TopologicalSort(v);

        for(int i =0 ; i < e; i++){
            System.out.print("Enter the start vertex: ");
            int a = scanner.nextInt();
            System.out.print("Enter the end vertex: ");
            int b = scanner.nextInt();
            g.addEdge(a,b);
        }

        System.out.println("Enter the start index: ");
        int startIndex = scanner.nextInt();
        g.topologicalSort(startIndex);
    }
}