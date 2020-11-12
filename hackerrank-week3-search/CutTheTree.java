import java.util.*;

public class CutTheTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] data = new long[n];

        for(int i=0; i<n; i++) {// change n to data.size() when pasting the hackerRank
            data[i] = scanner.nextLong();
        }
        Graph G = new Graph(n, data);
        for(int i=0; i<n-1; i++) {
            int u = scanner.nextInt()-1;
            int m = scanner.nextInt()-1;
//            System.out.println(u +" " + m);
            G.addEdge(u,m);
        }

//        int max = data.stream().mapToInt(Integer::intValue).sum();
        G.runDFS(0);
        long min = Long.MAX_VALUE;
        for( int i = 0 ; i < n ; i++)
        {
            long x = Math.abs( G.sum - 2*data[i]);
            if( x < min)
            {
                min = x;
            }
        }
        System.out.println(min);
        scanner.close();
    }




}

class Graph {
    ArrayList<Integer>[] graph;
    int V;
    long sum;
    long[] data;
    boolean[] visited;
    HashMap<Integer, Integer> map = new HashMap<>();
    Stack<Integer> stack  = new Stack<>();

    Graph(int node, long[] data) {
        V = node;
        this.data = data;
        graph = new ArrayList[V];
        for (int i=0; i<V; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[V];
        sum = Arrays.stream(data).sum();

    }

    void addEdge(int v, int u) {
        graph[v].add(u);
        graph[u].add(v);
    }

     int getNeighbour( int index) {
        for( int i = 0 ; i < graph[index].size() ; i ++)
        {
            int v = graph[index].get(i);

            if(!visited[v]) {
                return v;
            }
        }
        return -1;

    }

    void deepFirstSearch(int node) {
        stack.add(node);
        map.put(node, -1);
        visited[node]  =true;
//        System.out.print(node + " ");
//        stack.push(node);

        while (stack.size() >= 1) {
            int s = stack.peek();
            int next = getNeighbour(s);

            if (next == -1) {
                int out = stack.pop();

                long total = data[out];
                for (int j=0; j<graph[out].size(); j++) {
                    int k = graph[out].get(j);
                    total += data[k];
                }
                data[out] = total;
                if(map.get(out) != -1) {
                    data[out] -= data[map.get(out)];
                }
            } else {
                map.put(next, s);
                stack.add(next);
                visited[next] = true;
            }
        }
//        long diff =  Math.abs(sum - total - total);
//        this.minDiff = Math.min(this.minDiff, diff);


//        System.out.println("total= " + total);
//        System.out.println("diff is : " + diff);


    }

    void runDFS(int initial) {

//        System.out.println("DFS is running!");
        deepFirstSearch(initial);
    }

}


