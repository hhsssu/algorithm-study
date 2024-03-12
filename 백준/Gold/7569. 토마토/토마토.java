import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N, H;
    static int[][][] visit; // visit 배열은 토마토가 익는데 걸리는 일수를 저장
    static int[] dr = { -1, 1, 0, 0, 0, 0 }; // 위, 아래, 좌, 우, 앞, 뒤
    static int[] dc = { 0, 0, -1, 1, 0, 0 };
    static int[] dh = { 0, 0, 0, 0, -1, 1 };
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        visit = new int[H][N][M];

        for (int h = 0; h < H; h++) {
            for (int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < M; c++) {
                    int status = Integer.parseInt(st.nextToken());
                    visit[h][r][c] = status;
                    if (status == 1) {
                        queue.offer(new int[] { h, r, c });
                    }
                }
            }
        }

        bfs();

        int maxDay = 0;
        for (int h = 0; h < H; h++) {
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (visit[h][r][c] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    maxDay = Math.max(maxDay, visit[h][r][c]);
                }
            }
        }

        System.out.println(maxDay - 1); // 처음에 1로 시작했으므로 1을 빼줌
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int h = current[0];
            int r = current[1];
            int c = current[2];

            for (int i = 0; i < 6; i++) {
                int nextH = h + dh[i];
                int nextR = r + dr[i];
                int nextC = c + dc[i];

                if (nextH < 0 || nextH >= H || nextR < 0 || nextR >= N || nextC < 0 || nextC >= M)
                    continue;

                if (visit[nextH][nextR][nextC] == 0) {
                    visit[nextH][nextR][nextC] = visit[h][r][c] + 1;
                    queue.offer(new int[] { nextH, nextR, nextC });
                }
            }
        }
    }
}
