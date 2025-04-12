import java.io.*;
import java.util.*;

public class Main {
  public static int n, m, k;
  public static int[] parent;
  public static class Node implements Comparable<Node> {
    int start, end, cost;

    Node(int start, int end, int cost){
      this.start = start;
      this.end = end;
      this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
      return this.cost-o.cost;
    }

  }
  public static int find(int x) {
    if (parent[x] == -1) return -1;
    if (parent[x] == x) return x;
    return parent[x] = find(parent[x]);
  }
  public static boolean union(int x, int y){
    x = find(x);
    y = find(y);
    if (x == -1 && y != -1) {
      parent[y] = -1;
      return true;
    }
    if (y == -1 && x != -1){
      parent[x] = -1;
      return true;
    }
    if (x == y) return false;
    parent[y] = parent[x];
    return true;
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    int ans = 0;
    parent = new int[n+1];
    for (int i = 1; i <= n; i++) {
      parent[i] = i;
    }
    PriorityQueue<Node> pq = new PriorityQueue<>();
    st = new StringTokenizer(br.readLine());
    for (int i=0; i<k; i++){
      int plant = Integer.parseInt(st.nextToken());
      parent[plant] = -1;
    }
    for (int j=0; j<m; j++){
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());
      pq.add(new Node(start, end, cost));
    }
    while (!pq.isEmpty()){
      Node node = pq.poll();
      if (union(node.start, node.end)){
        ans += node.cost;
      }
    }
    bw.write(String.valueOf(ans));
    bw.flush();
    bw.close();
  };
}
