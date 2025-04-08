import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[] app = new int[n+1];
    int[] cost = new int[n+1];
    st = new StringTokenizer(br.readLine());
    for (int i=1; i <= n; i++) {
      app[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    for (int i=1; i <= n; i++) {
      cost[i] = Integer.parseInt(st.nextToken());
    }
    int max_c = Arrays.stream(cost).sum();
    int[][] dp  = new int[n+1][max_c+1];
    for (int j=1; j <= n; j++) {
      for (int k=0; k < max_c+1; k++){
        if (k < cost[j]){
          dp[j][k] = dp[j-1][k];
        } else{
          dp[j][k] = Math.max(dp[j-1][k], dp[j-1][k-cost[j]]+app[j]);
        }
      }
    }
    for (int c=0; c<=max_c; c++){
      if (dp[n][c] >= m){
        bw.write(String.valueOf(c));
        break;
      }
    }
    bw.flush();
    bw.close();
  };
}
