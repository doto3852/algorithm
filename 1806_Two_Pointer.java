import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int s = Integer.parseInt(st.nextToken());
    int[] arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i=0; i < n; i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }
    int start = 0;
    int end = 0;
    int sum = 0;
    int ans = 1000000;
    while (true) {
      if (sum >= s) {
        ans = Math.min(ans, end - start);
        sum -= arr[start++];
      } else if (end == n) {
        break;
      } else {
        sum += arr[end++];
      }
    }
    if (ans == 1000000) {
      bw.write("0");
    } else{
      bw.write(String.valueOf(ans));
    }
    bw.flush();
    bw.close();
  };
}
