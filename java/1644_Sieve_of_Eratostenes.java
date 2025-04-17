import java.io.*;
import java.util.*;

public class Main {
  public static int n;
  public static boolean[] sieve;
  public static int[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    sieve = new boolean[n+1];
    int cnt = 1;
    int ans = 0;
    int curr = 0;
    for (int i=2; i<=Math.sqrt(n); i++){
      if (!sieve[i]) {
        for (int j=i*i; j<=n; j+=i) {
          if (!sieve[j]){
            sieve[j] = true;
            cnt += 1;
          }
        }
      }
    }
    arr = new int[n-cnt];
    for (int i=2; i <= n; i++) {
      if (!sieve[i]){
        arr[curr] = i;
        curr += 1;
      }
    }
    int start = 0;
    int end = 0;
    int sum = 0;
    while (true){
      if (sum == n) {
        ans++;
        if (end == n-cnt) break;
        sum += arr[end++];
      } else if (sum < n) {
        if (end == n-cnt) break;
        sum += arr[end++];

      } else {
        sum -= arr[start++];
      }
    }
    bw.write(String.valueOf(ans));

    bw.flush();
    bw.close();
  };
}
