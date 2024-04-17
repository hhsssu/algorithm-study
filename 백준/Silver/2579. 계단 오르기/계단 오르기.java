import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		int[] stairs = new int[N + 1];
		int[] dp = new int[N + 1];

		// 계단 값 받아오기
		for (int i = 1; i <= N; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}

		// 시작점 0은 값을 가지지 않고 카운트도 x
//		dp[0] = 0;
		dp[1] = stairs[1];

		// N이 1인 경우가 있을 수 있으므로
		if (N >= 2) {
			
			// 2계단일 때 최댓값
			dp[2] = dp[1] + stairs[2];

			for (int i = 3; i <= N; i++) {
				// ex. i=4일때, 2번 계단 까지의 값 or 1번 계단까지 최댓값 + 3번 계단값
				// ex. i=5일때, 3번 계단 까지의 값 or 2번 계단까지 최댓값 + 4번 계단값
				// 연속 3번 밟기 방지
				dp[i] = Math.max(dp[i - 2], dp[i - 3] + stairs[i - 1]) + stairs[i];
			}
		}

		System.out.println(dp[N]);
	}
}