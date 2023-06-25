import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* [ DFS ] 아파트단지번호붙이기 2667번 */
public class Beak_2667_아파트단지번호붙이기 {

    static int N, cnt;
    static int[][] arr;
    static ArrayList<Integer> ansArr = new ArrayList<>();
    static boolean[][] visited;

    static int[] directX = {0, 1, -1, 0};
    static int[] directY = {1, 0, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < N; j++) {
                int location = line.charAt(j) - '0';
                arr[i][j] = location;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    cnt = 1;
                    dfs(i, j);
                    ansArr.add(cnt);
                }
            }
        }

        System.out.println(ansArr.size());
        for (int ans : ansArr) {
            System.out.println(ans);
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nowX = x + directX[i]; //현재 x좌표 위치
            int nowY = y + directY[i]; //현재 y좌표 위치

            //범위 체크
            if (nowX > -1 && nowY > -1 && nowX < N && nowY < N && arr[nowX][nowY] == 1 && !visited[nowX][nowY]) {
                cnt++;
                dfs(nowX, nowY);
            }
        }
    }
}
