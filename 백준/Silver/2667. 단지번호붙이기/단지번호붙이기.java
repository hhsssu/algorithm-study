import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	static int[][] map;
	static int N, vCnt, hCnt;
	static List<Integer> house;
	// 델타배열 상, 하, 좌, 우
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 마을 크기
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		house = new ArrayList<>();

		// 마을 정보 받아오기
		for (int r = 0; r < N; r++) {
			String line = br.readLine();
			for (int c = 0; c < N; c++) {
				map[r][c] = line.charAt(c) - '0';
			}
		}

		// 탐색 시작
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				hCnt = 0; // 집 개수 초기화
				if (map[r][c] == 1) { // 집이 있고 방문 안된 곳
					vCnt++; // 단지 개수 +1
					hCnt++;
					map[r][c] = 2; // 방문처리
					DFS(r, c);
				}
				if(hCnt > 0) {
					house.add(hCnt);
				}
			}
		}
		
		// List 오름차순 정렬
		Collections.sort(house);
		
		// 출력
		System.out.println(vCnt);
		for(int i = 0; i < house.size(); i++) {			
			System.out.println(house.get(i));
		}
	}

	public static void DFS(int x, int y) {
		int nowX = x;
		int nowY = y;
		
		// 4방향 탐색
		for (int d = 0; d < 4; d++) {
			int nextX = nowX + dx[d];
			int nextY = nowY + dy[d];
			
			// 경계값
			if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) {
				continue;
			}
			
			// 집 없거나 방문 한 곳
			if(map[nextX][nextY] != 1) {
				continue;
			}
			
			map[nextX][nextY] = 2;
			hCnt++;
			// 다음 위치 탐색
			DFS(nextX, nextY);
		}
	}
}
