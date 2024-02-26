import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 시계방향인 우-하-좌-상으로 델타배열 생성
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };

		// 가로 C, 세로 R 크기의 좌석
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		// 2차원 배열 생성
		int[][] seats = new int[R][C];

		// 어떤 관람객 대기 번호
		int K = Integer.parseInt(br.readLine());

		if (K <= C * R) { // 대기번호가 좌석 수보다 작을 때만 비교

			// 몇번째 자리 앉을지 알아보기
			// 벽을 만나거나 0이 아닌 값이 있으면 방향 변경한다.
			int y = 0;
			int x = 0;
			int d = 0;

			for (int i = 1; i <= K; i++) { // 대기번호 for문
				seats[y][x] = i;

				// 경계값 안맞고, 다음 배열의 값이 0이 아닐 때 방향 전환
				if (y + dr[d] < 0 || y + dr[d] >= R || x + dc[d] < 0 || x + dc[d] >= C
						|| seats[y + dr[d]][x + dc[d]] != 0) {
					d = (d + 1) % 4; // 델타값 변경
				}
				if (i != K) {
					y += dr[d];
					x += dc[d];
				}

			}
			// 좌석 번호 출력
			System.out.println((y+1) + " " + (x+1));

		} else { // 해당 대기번호의 관객에게 좌석을 배정할 수 없는 경우
			System.out.println(0);
		}

	}
}
