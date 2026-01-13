import java.io.*;
import java.util.*;

public class Main {
  public static int r, c, k, ans;
  public static char[][] arr;
  public static boolean[][] visited;
  public static int[] dy = {0, 0, -1, 1};
  public static int[] dx = {-1, 1, 0, 0};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    arr = new char[r][c];
    visited = new boolean[r][c];
    ans = 0;
    for (int i=0; i<r; i++){
      String s = br.readLine();
      arr[i] = s.toCharArray();
    }
    visited[r-1][0] = true;
    dfs(r-1, 0, 1);
    System.out.println(ans);
  }

  public static void dfs(int y, int x, int level){
    if (y == 0 && x == c-1 && level == k) {
      ans += 1;
      return;
    } else if (level >= k) {
      return;
    }
    for (int i=0; i<4;i++){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if (ny < 0 || nx < 0 || ny >= r || nx >= c) {
          continue;
        } else if (arr[ny][nx] == 'T' || visited[ny][nx]) {
          continue;
        }
        visited[ny][nx] = true;
        dfs(ny, nx, level+1);
        visited[ny][nx] = false;
    }
  }
}
