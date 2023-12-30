import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Prims {
    static class Pair implements Comparable<Pair>{
        int wt;
        int v;
        Pair(int v, int wt){
            this.v = v;
            this.wt = wt;
        }

        public int compareTo(Pair that){
            return this.wt - that.wt;
        }
    }

    static int spanningTree(ArrayList<ArrayList<ArrayList<Integer>>> g, int n){
            boolean[] vis = new boolean[n];
            PriorityQueue<Pair> q = new PriorityQueue<>();

            q.add(new Pair(0,0));
            int ans = 0;

            while(!q.isEmpty()){
                Pair cur = q.remove();
                int dest = cur.v;
                if(vis[dest]){
                    continue;
                }

                ans+=cur.wt;
                vis[dest] = true;

                ArrayList<ArrayList<Integer>> neighbours = g.get(dest);

                for(ArrayList<Integer> neighbour : neighbours){
                    int vertex = neighbour.get(0);
                    int wt = neighbour.get(1);

                    if(!vis[vertex]){
                        q.add(new Pair(vertex, wt));
                    }
                }
            }

            return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<ArrayList<ArrayList<Integer>>> g = new ArrayList<>();
        System.out.println("Enter the number of vertices: ");
        int n = scanner.nextInt();

        for(int i =0 ; i < n; i++){
            ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
            System.out.println("Enter the number of edges going from " + i);
            int m = scanner.nextInt();
            for(int j = 0; j < m; j++){
                ArrayList<Integer> edge = new ArrayList<>();
                System.out.println("Enter the destination, weight from " + i);
                 edge.add(scanner.nextInt());
                edge.add(scanner.nextInt());
                edges.add(edge);
            }
            g.add(edges);
        }

        int ans = spanningTree(g, n);

        System.out.println("The minimun spanning tree is: " + ans );

    }
}
