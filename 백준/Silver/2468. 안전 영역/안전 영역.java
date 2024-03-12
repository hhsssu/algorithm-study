import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int rain, cnt, max, maxSafe; // 빗물높이, 안전영역 수, 가장 높은 지대, 안전영역 최댓값
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		visited = new boolean[N][N];

		max = 0;

		// 지역 정보 담기
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				int a = Integer.parseInt(st.nextToken());
				map[r][c] = a;
				max = Math.max(a, max); // 최댓값
			}
		}
		
		maxSafe = 0;
		for (rain = 0; rain <= max; rain++) {
			
			cnt = 0;
			visited = new boolean[N][N]; // 방문체크 초기화
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] > rain && !(visited[r][c])) {
						visited[r][c] = true;
						DFS(r, c);
						cnt++;
					}
				}
			}
			maxSafe = Math.max(cnt, maxSafe); 
		}

		System.out.println(maxSafe);
	}

	private static void DFS(int x, int y) {

		int nowX = x;
		int nowY = y;

		for (int d = 0; d < dr.length; d++) {
			int nextX = nowX + dr[d];
			int nextY = nowY + dc[d];

			// 경계값
			if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) {
				continue;
			}

			// 수위보다 작거나 이미 방문한 곳
			if (map[nextX][nextY] <= rain || visited[nextX][nextY]) {
				continue;
			}

			visited[nextX][nextY] = true;
			DFS(nextX, nextY);

		}
	}
}
