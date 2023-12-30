import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Pair implements Comparable<Pair>{
    int src;
    int wt;

    public Pair(int src, int wt){
        this.src = src;
        this.wt = wt;
    }

    public int compareTo(Pair that){
        return this.wt - that.wt;
    }
}

public class Dijkstra {
    public static int[] dijkstra(int src, int v, ArrayList<ArrayList<ArrayList<Integer>>> adj){
        boolean[] vis = new boolean[v];
        PriorityQueue<Pair> q = new PriorityQueue<>();
        int[] ans = new int[v];

        Arrays.fill(ans, 10000000);
        ans[src] = 0;
        q.add(new Pair(src, 0));

        while(!q.isEmpty()){
            Pair cur = q.remove();
            int u = cur.src;

            if(vis[u]){
                continue;
            }

            vis[u] = true;

            ArrayList<ArrayList<Integer>> neighbours = adj.get(u);
            for(ArrayList<Integer> neighbour : neighbours ){
                int dest = neighbour.get(0);
                int wt = neighbour.get(1);


                if(ans[dest] > ans[u] + wt){
                    ans[dest] = ans[u] + wt;
                    q.add(new Pair(dest, ans[u] + wt));
                }

            }

        }

        return ans;
    }

    public static void main(String[] args) {
//        Create the graph in adj way
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        int v = scanner.nextInt();

        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

        for(int i = 0; i < v; i++){
            System.out.println("Enter the number of edges from " + i);
            int n = scanner.nextInt();
            ArrayList<ArrayList<Integer>> neighbours = new ArrayList<>();
            for(int j = 0; j < n; j++){
                ArrayList<Integer> temp = new ArrayList<>();
                int dest = scanner.nextInt();
                int w = scanner.nextInt();
                temp.add(dest);
                temp.add(w);
                neighbours.add(temp);
            }

            adj.add(neighbours);
        }

        System.out.println("Enter the source: ");
        int src = scanner.nextInt();

        int[] ans = dijkstra(src, v, adj);

        for(int i = 0; i < ans.length; i++){
            System.out.println(i + " - " + ans[i]);
        }

    }
}
