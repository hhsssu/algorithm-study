import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] nums, result;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		nums = new int[N];
		result = new int[M];
		visited = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			nums[i] = i+1;
		}

		perm(0);
		
		System.out.println(sb);

	}

	private static void perm(int idx) {

		if (idx == M) {
			for (int i = 0; i < M; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			// 사용했다
			if (visited[i])
				continue;

			// 사용 안함
			result[idx] = nums[i];
			visited[i] = true; // 사용 완료
			perm(idx + 1);
			visited[i] = false; // 원복
		}
	}
}
