import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 스위치 개수 N
		int N = Integer.parseInt(br.readLine());
		// 스위치 상태 담을 배열
		int[] switches = new int[N + 1];

		// 스위치 상태 받아오기
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			int info = Integer.parseInt(st.nextToken());
			switches[i] = info;
		}

		// 학생 수
		int studentNum = Integer.parseInt(br.readLine());

		for (int i = 0; i < studentNum; i++) {
			
			// 성별 받아오기
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()); // 성별
			int num = Integer.parseInt(st.nextToken()); // 받은 스위치 번호
			
			// 받은 스위치 번호의 스위치 상태 먼저 변경
			if (switches[num] == 0)
				switches[num] = 1;
			else
				switches[num] = 0;

			
			switch (s) {
			
			case 1: // 남학생
				int j = 2;
				while (num * j <= N) {
					if (switches[num * j] == 0)
						switches[num * j] = 1;
					else
						switches[num * j] = 0;
					j++;
				}
				break;

			case 2: // 여학생

				int nm = num - 1;
				int np = num + 1;

				// 스위치번호-1이 0이 아니고, 스위치번호+1이 N+1이 아닐때
				// 스위치 번호 -1과 스위치번호 +1의 값이 같으면 값 변경
				while (nm > 0 && np <= N && switches[nm] == switches[np]) {
					if (switches[nm] == 0 && switches[np] == 0) { // 0이면 1로 바꾸고
						switches[nm] = 1;
						switches[np] = 1;

					} else { // 1이면 0으로 바꿈
						switches[nm] = 0;
						switches[np] = 0;
					}
					nm--;
					np++;
				}
				break;
			}
		}

		// 출력
		for (int k = 1; k <= N; k++) {
			if (k % 20 == 1 && k != 1) {
				System.out.println();
			}
			System.out.print(switches[k] + " ");
		}
	}
}
