import java.util.*;

public class BFS {
    public static void bfs(int[][] adj, int st, int vertices){
        Map<Integer, Boolean> visited = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();

        visited.put(st, true);
        q.add(st);
        System.out.print(st);

        while(!q.isEmpty()){
            int cur = q.poll(); // q.pop() -> cpp
            for(int i = 0; i < vertices; i++){
                if(adj[cur][i] == 1 && !visited.containsKey(i)){
                    System.out.print(i + " ");
                    visited.put(i, true);
                    q.add(i);
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of vertices: ");
        int vertices = scanner.nextInt();

        int[][] adj = new int[vertices][vertices];

        for(int i = 0; i < vertices; i++){
            for(int j = 0; j < vertices; j++){
                adj[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Enter the start vertex: ");
        int startVertex = scanner.nextInt();

        bfs(adj, startVertex, vertices);

    }
}
