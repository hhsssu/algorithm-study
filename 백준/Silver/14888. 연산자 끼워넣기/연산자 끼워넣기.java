import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, max, min; // 숫자 개수, 최댓값, 최솟값
	static int[] nums, operators, visited; // 숫자들, 연산자, 방문체크

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

			N = Integer.parseInt(br.readLine());
			nums = new int[N];
			operators = new int[4];
			visited = new int[4];

			// 최댓값, 최솟값 초기화
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;

			// 숫자 저장
			// 숫자 순서 변경 불가!(배열로 받아오자)
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			
			// 연산자 저장
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				operators[i] = Integer.parseInt(st.nextToken());
			}


			cal(nums[0], 1);

			System.out.println(max);
			System.out.println(min);

	}

	// 계산
	static void cal(int result, int idx) {
		// 연산자 우선순위를 따지지 않고, 왼쪽부터 계산한다.
		// 연산값 재귀
		// 기저조건
		if (idx == N) {
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}

		if (operators[0] > visited[0]) { // +
			visited[0]++;
			cal(result + nums[idx], idx + 1);
			visited[0]--;
		}
		if (operators[1] > visited[1]) { // -
			visited[1]++;
			cal(result - nums[idx], idx + 1);
			visited[1]--;
		}
		if (operators[2] > visited[2]) { // *
			visited[2]++;
			cal(result * nums[idx], idx + 1);
			visited[2]--;
		}
		if (operators[3] > visited[3]) { // /
			visited[3]++;
			cal(result / nums[idx], idx + 1);
			visited[3]--;
		}

	}
}
