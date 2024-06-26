import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] nums, sel;
	static int N, M;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		nums = new int[N];
		sel = new int[M];
		
		for (int i = 0; i < N; i++) {
			nums[i] = i + 1;
		}
		combination(0, 0);
		System.out.println(sb);

	}

	private static void combination(int idx, int sidx) {

		if(sidx == M) {
			for(int i = 0; i < M; i++) {
				sb.append(sel[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < N; i++) {
			sel[sidx] = nums[i];
			combination(i+1, sidx+1);
		}

	}
}
