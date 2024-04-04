import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 물품 수
		int K = Integer.parseInt(st.nextToken()); // 준서가 버틸 수 있는 무게

		int[] weight = new int[N + 1];
		int[] cost = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			cost[i] = Integer.parseInt(st.nextToken());
		}

		int[][] dp = new int[N + 1][K + 1];

		for (int i = 1; i <= N; i++) { // 1~N개의 물건 비교
			for (int j = 0; j <= K; j++) { // 임시 무게
				if (weight[i] <= j) { // 현재 무게보다 가벼우면 넣을지말지
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + cost[i]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		System.out.println(dp[N][K]);
	}
}
