import java.io.*;
import java.util.*;

public class Main {
  public static int n;
  public static int[] count;
  static class Task {
    int time;
    int index;

    Task(int time, int index) {
      this.time = time;
      this.index = index;
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    count = new int[n+1];
    int[] timeList = new int[n+1];
    int ans = 0;
    List<List<Integer>> arr = new ArrayList<>();
    PriorityQueue<Task> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.time));
    for (int i=0; i<=n; i++) {
      arr.add(new ArrayList<>());
    }
    for (int i=1; i<=n; i++){
      st = new StringTokenizer(br.readLine());
      int time = Integer.parseInt(st.nextToken());
      int front = Integer.parseInt(st.nextToken());
      timeList[i] = time;
      if (front > 0) {
        for (int j=0; j<front; j++){
          int f = Integer.parseInt(st.nextToken());
          arr.get(f).add(i);
          count[i]++;
        }
      } else {
        pq.add(new Task(time, i));
      }
    }
    while (!pq.isEmpty()){
      Task curr = pq.poll();
      for (int x: arr.get(curr.index)){
        count[x]--;
        if (count[x] == 0){
          pq.add(new Task(curr.time + timeList[x], x));
        }
      }
      ans = curr.time;
    }
    bw.write(String.valueOf(ans));
    bw.flush();
    bw.close();
  };
}
