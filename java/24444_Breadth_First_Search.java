import java.io.*;
import java.util.*;

public class Main {
  public static int n, m, s;
  public static List<List<Integer>> graph;;
  public static int[] visited;
  public static int seq = 1;
  public static Queue<Integer> q = new ArrayDeque<>();


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    s = Integer.parseInt(st.nextToken());
    graph = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }
    visited = new int[n+1];
    visited[s] = 1;
    q.add(s);
    for (int i=0; i< m; i++){
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      graph.get(s).add(e);
      graph.get(e).add(s);
    }
    for (List<Integer> neighbors : graph) {
      Collections.sort(neighbors);
    }
    while (!q.isEmpty()){
      int x = q.poll();
      for (int node: graph.get(x)){
        if (visited[node] == 0){
          q.add(node);
          visited[node] = ++seq;
        }
      }
    }
    for (int i=1; i <= n; i++){
      bw.write(String.valueOf(visited[i]));
      bw.newLine();
    }
    bw.flush();
    bw.close();
  };
}
