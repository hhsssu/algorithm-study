import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int N, M; // 맵 크기
	public static int[][] map; // 미로 정보
	public static boolean[][] visited; // 방문 정보
	// 델타 배열
	public static int[] dr = { -1, 1, 0, 0 }; // 상하좌우
	public static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];

		// 미로 정보 저장
		for (int r = 0; r < N; r++) {
			String str = br.readLine();
			char[] ch = str.toCharArray();
			for (int c = 0; c < M; c++) {
				map[r][c] = ch[c] - '0';
			}
		}

		visited[0][0] = true;

		BFS(0, 0);

		System.out.println(map[N-1][M-1]);
	}

	public static void BFS(int x, int y) {
		// 방문 정보 담을 큐
		Queue<int[]> queue = new LinkedList<>();

		// 방문한 위치 큐에 저장
		queue.offer(new int[] { x, y });

		while (!queue.isEmpty()) {
			int[] visit = queue.poll(); // 꺼내오고 삭제
			int nowX = visit[0];
			int nowY = visit[1];

			for (int i = 0; i < 4; i++) { // 다음으로 이동
				int nextX = nowX + dr[i];
				int nextY = nowY + dc[i];

				// 경계값이 넘어가면
				if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) {
					continue; // 그냥 넘어감 (다른 방향 탐색하러)
				}

				// 방문하지 않아도 되는 곳이면(벽 혹은 이미 방문한 곳)
				if (map[nextX][nextY] == 0 || visited[nextX][nextY]) {
					continue; // 그냥 넘어감 (다른 방향 탐색하러)
				}
				

				// 그 외 경계값 안넘고, 길이 있는 경우
				// 방문했다고 표시
				visited[nextX][nextY] = true;
				// 큐에 다음 길 위치 값 저장
				queue.offer(new int[] { nextX, nextY });
				// 맵에 다음 길 위치에 현재위치값 + 1
				map[nextX][nextY] = map[nowX][nowY] + 1;

			}
		}
	}
}
