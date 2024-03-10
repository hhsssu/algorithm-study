import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int M, N;
	static int[][] tBox;
	static int max, nowX, nowY;
	static int[] dr = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dc = { 0, 0, -1, 1 };
	static Queue<int[]> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		tBox = new int[N][M];
		queue = new LinkedList<>();
		boolean info = false;
		// 토마토 상태 입력
		for (int r = 0; r < tBox.length; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < tBox[r].length; c++) {
				tBox[r][c] = Integer.parseInt(st.nextToken());
				if (tBox[r][c] == 0) { // 안익은 토마토가 있으면 true
					info = true;
				}
				
				if (tBox[r][c] == 1) {
					queue.offer(new int[] { r, c });
				}
			}
		}
		if (info) {

			max = 0; // 초기화
			
			// 토마토 익히기
			BFS();

			// 며칠 걸리는지 찾기
			here: for (int r = 0; r < tBox.length; r++) {
				for (int c = 0; c < tBox[r].length; c++) {
					max = Math.max(tBox[r][c], max);
					
					if (tBox[r][c] == 0) {
						max = 0;
						break here;
					}
				}
			}
			if (max == 0) {
				// 안익은 게 있는 상태
				max = -1;
			} else {
				max -= 1;
			}
		} else { // 모두 익은 상태
			max = 0;
		}

		System.out.println(max);

	}

	static void BFS() {

		while (!queue.isEmpty()) {
			int[] visit = queue.poll(); // 꺼내오고 삭제
			nowX = visit[0];
			nowY = visit[1];

			// 탐색
			for (int i = 0; i < dr.length; i++) {
				int nextX = nowX + dr[i];
				int nextY = nowY + dc[i];

				// 상자 밖이거나 토마토가 들어있지않다면(-1)
				if (nextX < 0 || nextX >= tBox.length || nextY < 0 || nextY >= tBox[nextX].length
						|| tBox[nextX][nextY] == -1) {
					continue;
				}

				// 상하좌우가 0보다 크고(방문한 곳), 현재값+1보다 작거나 같으면 넘어감
				if (tBox[nextX][nextY] != 0 && tBox[nextX][nextY] <= tBox[nowX][nowY] + 1) {
						continue;
				}

				// 그 외 0이면
				tBox[nextX][nextY] = tBox[nowX][nowY] + 1;

//				System.out.println();
//				for (int r = 0; r < tBox.length; r++) {
//					for (int c = 0; c < tBox[r].length; c++) {
//						System.out.print(tBox[r][c]);
//					}
//					System.out.println();
//				}

				queue.offer(new int[] { nextX, nextY });

			}
		}
	}
}
