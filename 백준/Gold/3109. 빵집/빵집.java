import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = { -1, 0, 1 }; // 우상, 우, 우하
	static int[] dc = { 1, 1, 1 };
	static int[][] map;
	static boolean[][] visited;
	static int cnt, R, C, result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		// 맵 정보 담을 배열
		map = new int[R][C];
		visited = new boolean[R][C]; // 방문체크할 배열

		// 맵 정보 저장
		for (int r = 0; r < R; r++) {
			String line = br.readLine();
			for (int c = 0; c < C; c++) {
				char chr = line.charAt(c);
				if (chr == 'x') { // 지나가기 불가능
					map[r][c] = 1;
				} else { // 지나갈 수 있는 곳
					map[r][c] = 0;
				}
			}
		}

		result = 0;
		// c가 0일때 출발 (다른 가게 가스배관)
		for (int r = 0; r < R; r++) {
			cnt = 0;
			visited[r][0] = true;
			findConnPipe(r, 0);
		}

		System.out.println(result);

	} // end of main method

	// 가능한 가스 배관 수 찾기
	static void findConnPipe(int r, int c) {

		// 만약, c가 C-1이면(도착지점) 멈추고 cnt +1
		if (c == C - 1) {
			cnt++;
			result++;
		}

		for (int d = 0; d < 3; d++) {
			int nextR = r + dr[d];
			int nextC = c + dc[d];

			if (nextR < 0 || nextR >= R || nextC < 0 || nextC >= C) {
				continue;
			}

			if (visited[nextR][nextC] || map[nextR][nextC] == 1) { // 이미 방문한 곳이거나 건물(1)
				continue;
			}

			// 이미 파이프 연결
			if (cnt > 0) {
				return;
			}

			visited[nextR][nextC] = true;
			findConnPipe(nextR, nextC);
		}

	} // end of findCnt method
} // end of Main class
