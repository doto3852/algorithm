import java.io.*;
import java.util.*;

public class Main {
  static List<List<Integer>> graph;
  static int[] visited;
  static int seq = 1;
  public static void dfs(int x){
    for (int v : graph.get(x)){
      if (visited[v] == 0){
        visited[v] = ++seq;
        dfs(v);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int r = Integer.parseInt(st.nextToken());
    graph = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }
    visited = new int[n+1];
    visited[r] = 1;
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
    dfs(r);
    for (int j=1; j<=n; j++){
      bw.write(String.valueOf(visited[j]));
      bw.newLine();
    }
    bw.flush();
    bw.close();
  };
}
