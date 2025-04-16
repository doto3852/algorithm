import java.io.*;
import java.util.*;

public class Main {
  public static int n;
  public static long m;
  public static long[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Long.parseLong(st.nextToken());
    long ans = Long.MAX_VALUE;
    arr = new long[n];
    long max_v = 0;
    for (int i=0; i<n; i++){
      arr[i] = Long.parseLong(br.readLine());
      max_v = Math.max(max_v, arr[i]);
    }
    long left = 0;
    long right = max_v * m;
    while (left <= right) {
      long mid = (left + right) / 2;
      long cnt = 0;
      for (int j=0; j<n; j++){
        cnt += mid/arr[j];
        if (cnt >= m) break;
      }
      if (cnt >= m) {
        ans = Math.min(ans, mid);
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    bw.write(String.valueOf(ans));

    bw.flush();
    bw.close();
  };
}
