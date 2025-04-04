import java.io.*;
import java.util.*;

public class Main {
  private static class Node{
  int cur;
  int dest;
  long dist;
  public Node(int cur, int dest, long dist){
    this.cur =cur;
    this.dest = dest;
    this.dist = dist;
  }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int s = Integer.parseInt(st.nextToken());
    long[] distance = new long[n+1];
    ArrayList<Node> graph = new ArrayList<>();
    for (int i=2; i <= n; i++){
      distance[i] = Integer.MAX_VALUE;
    }
    for (int j=0; j<s; j++){
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      long w = Integer.parseInt(st.nextToken());
      graph.add(new Node(u, v, w));
    }

    for (int k=0; k<n; k++){
      for (Node temp:graph){
        if (distance[temp.cur] != Integer.MAX_VALUE && distance[temp.cur] + temp.dist < distance[temp.dest]){
          distance[temp.dest] = distance[temp.cur] + temp.dist;

          if (k == n-1) {
            bw.write("-1");
            bw.flush();
            return;
          }
        }
      }
    }
    for (int i=2; i <= n; i++){
      if (distance[i] == Integer.MAX_VALUE){
        bw.write("-1 \n");
      } else {
        bw.write(String.valueOf(distance[i]) + "\n");
      }

    }
    bw.flush();
    bw.close();
  };
}
