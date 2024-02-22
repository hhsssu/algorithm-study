import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 참외밭
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//		1. 필요한 변수 선언 및 초기화
//		- 참외의 개수를 나타내는 양의 정수 K
		int K = Integer.parseInt(br.readLine());

//		- 6면 길이 정보 담을 7크기의 1차원 배열
		int[] farm = new int[7];

//		- 짝수 인덱스에서 가장 큰 값 담을 정수형 변수
		int max2 = 0;
		int max2Idx = 0;
//		- 홀수 인덱스에서 가장 큰 값 담을 정수형 변수
		int max1 = 0;
		int max1Idx = 0;
//		- 최종 넓이 값
		int resultSum = 0;

//		2. 참외밭 6면 길이 받아오기
		for (int i = 1; i <= 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int way = Integer.parseInt(st.nextToken());
			farm[i] = Integer.parseInt(st.nextToken());

			if (i % 2 == 0) { // 인덱스가 짝수면
				if (farm[i] > max2) {
					max2 = farm[i];
					max2Idx = i;
				}
			} else { // 홀수면
				if (farm[i] > max1) {
					max1 = farm[i];
					max1Idx = i;
				}
			}
		}
		int maxIdx = max1Idx; // 인덱스번호 담기
		int a, b; // 작은 가로, 세로 길이 받아오기

//		인덱스번호끼리 비교해서 인덱스 번호가 더 큰 값 찾기
		if (max2Idx > max1Idx) {
			maxIdx = max2Idx;
			if (maxIdx - 1 != max1Idx) {
				maxIdx = max1Idx;
			}
		}

		if (maxIdx + 2 > 6) {
			a = farm[maxIdx + 2 - 6];
			b = farm[maxIdx + 3 - 6];
		} else {
			a = farm[maxIdx + 2];
			if (maxIdx + 3 > 6) {
				b = farm[maxIdx + 3 - 6];
			} else {
				b = farm[maxIdx + 3];
			}
		}
//		System.out.printf("max1: %d, max2: %d\n", max1, max2);
//		System.out.printf("maxIdx: %d\n", maxIdx);
//		System.out.printf("a: %d, b: %d\n", a, b);
//		최대 넓이 - 작은 부분 넓이
		resultSum = (max1 * max2 - a * b) * K;

		System.out.println(resultSum);
	}
}