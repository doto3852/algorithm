import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int t = Integer.parseInt(st.nextToken());

    for (int i=0; i < t; i++){
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int[] adjl = new int[n+1];
      Set<Integer> set = new HashSet<>();
      for (int j = 0; j < n-1; j++) {
        st = new StringTokenizer(br.readLine());
        int a  = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        adjl[b] = a;
      }
      st = new StringTokenizer(br.readLine());
      int c  = Integer.parseInt(st.nextToken());
      int d = Integer.parseInt(st.nextToken());
      while (c!= 0) {
        set.add(c);
        c = adjl[c];
      }
      while (d !=0){
        if (set.contains(d)){
          bw.write(String.valueOf(d));
          bw.newLine();
          break;
        }
        d = adjl[d];
      }
    }
    bw.flush();
    bw.close();
  };
}
