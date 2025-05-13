import java.io.*;
import java.util.*;

public class Main {
  public static int n,m,k;
  public static long[] arr;
  public static long[] segmentTree;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    arr = new long[n];
    segmentTree = new long[n*4];
    for (int i = 0; i < n; i++){
      arr[i] = Long.parseLong(br.readLine());
    }
    init(0, n-1, 1);

    for (int i=0; i<m+k; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      long c = Long.parseLong(st.nextToken());
      if (a == 1) {
        nodeUpdate(b-1, c, 0, n-1, 1);
      } else {
        bw.write(String.valueOf(query(0, n-1, 1, b-1, (int)c-1)));
        bw.newLine();
      }
    }

    bw.flush();
    bw.close();
  };

  static long init(int start, int end, int node) {
    if (start == end) {
      segmentTree[node] = arr[start];
      return segmentTree[node];
    }
    int mid = (start + end) / 2;
    long left = init(start, mid, node * 2);
    long right = init(mid+1, end, node * 2 + 1);
    segmentTree[node] = left + right;
    return segmentTree[node];
  }

  static void nodeUpdate(int target, long newVal, int start, int end, int node) {
    if (target < start || target > end) {
      return;
    }
    if (start == end) {
      segmentTree[node] = newVal;
      arr[start] = newVal;
      return;
    }

    int mid = (start + end) / 2;
    nodeUpdate(target, newVal, start, mid, node * 2);
    nodeUpdate(target, newVal, mid + 1, end, node * 2 + 1);
    segmentTree[node] = segmentTree[node * 2] + segmentTree[node * 2 + 1];
  }

  static long query(int start, int end, int node, int left, int right){
    if (right < start || end < left) return 0;
    if (left <= start && end <= right) return segmentTree[node];

    int mid = (start + end) / 2;
    return query(start, mid, node*2, left, right) + query(mid + 1, end, node*2+1, left, right);
  }
}
