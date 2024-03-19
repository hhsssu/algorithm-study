import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int node, line, x, y, cnt;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		node = Integer.parseInt(br.readLine());
		line = Integer.parseInt(br.readLine());

		arr = new int[node + 1][node + 1];
		visited = new boolean[node + 1];

		for (int i = 0; i < line; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		cnt = 0;
		visited[1] = true;
		dfs(1);
		
		System.out.println(cnt);

	}

	private static void dfs(int start) {

		for (int i = 1; i <= node; i++) {
			if (arr[start][i] == 0 || visited[i]) {
				continue;
			}

			// 1이고 방문 안한 곳
			visited[i] = true; // 방문처리
			cnt++;
			dfs(i);
		}
	}
}
