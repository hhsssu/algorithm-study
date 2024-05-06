import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	// 대각선(우하, 좌하, 좌상, 우상)
	static int[] dr = { 1, 1, -1, -1 };
	static int[] dc = { 1, -1, -1, 1 };
	static int[][] map;
	static boolean[] cafe;
	static boolean[][] visited;
	static int N, startR, startC, max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");

			N = Integer.parseInt(br.readLine()); // 맵 크기
			map = new int[N][N];

			max = 0;

			int cafeNum = 0; // 카페 번호 중 가장 큰 번호 담을 변수
			// 카페 정보 담기
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					cafeNum = Math.max(map[r][c], cafeNum); // 카페 배열 만들 가장 큰 카페 번호 저장
				}
			}

			// 탐색 시작
			for (int r = 0; r < N - 2; r++) {
				for (int c = 1; c < N - 1; c++) {
					// (0, 0), (0, N-1), (N-1, 0), (N-1, N-1)은 탐색 시작에 해당 안됨.
					// 카페 방문체크할 배열 초기화
					cafe = new boolean[cafeNum + 1];
					visited = new boolean[N][N];

					// 시작 위치 저장
					startR = r;
					startC = c;

					// 방문처리
					visited[startR][startC] = true;
					cafe[map[startR][startC]] = true;

					DFS(startR, startC, 1, 0);
				}
			} // 탐색 끝
			if (max == 0) { // 방문한 가게 가장 큰 횟수가 3곳 이하면 (사각형 안됨)
				// max값을 다 0으로 초기화 해줬으므로 1이상 3이하의 값이 나오지 않음
				sb.append(-1).append("\n");
			} else { // 방문한 가게가 4곳 이상이면
				sb.append(max).append("\n");
			}
		}
		System.out.println(sb);
	} // main method 끝

	static void DFS(int nowX, int nowY, int cnt, int dir) {

		// 이전 방향으로는 안가게 방향도 함께 넘겨줌 (dir)
		for (int d = dir; d < 4; d++) {
			int nextX = nowX + dr[d];
			int nextY = nowY + dc[d];

			// 경계값 (범위 밖)
			if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
				continue;
			}


			// 시작지점으로 복귀했다! 그리고 시작점 제외 3곳 이상 들렀다!
			if ((nextX == startR && nextY == startC) && cnt >= 3) {
				max = Math.max(max, cnt); // 가장 방문 많이 할 수 있는 수 max
				return; // 종료!
			}

			// 시작지점은 아니지만, 이미 방문했거나, 같은 디저트이면
			if (visited[nextX][nextY] || cafe[map[nextX][nextY]]) {
				continue;
			}

			// 시작지점X, 방문X, 같은 디저트X
			// 방문처리
			visited[nextX][nextY] = true;
			cafe[map[nextX][nextY]] = true;
			// 재귀
			DFS(nextX, nextY, cnt + 1, d);
			// 방문처리 취소
			visited[nextX][nextY] = false;
			cafe[map[nextX][nextY]] = false;
		} // 방향 이동 끝
	} // DFS 끝
} // Solution class 끝
