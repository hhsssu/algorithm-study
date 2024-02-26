import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 학생 수
		int sNum = sc.nextInt();
		
		// 학생들 줄세울 리스트 선언
		List<Integer> sList = new ArrayList<>();
		
		// 학생들 번호 뽑기
		for(int i = 0; i < sNum; i++) {
			int sIdx = sc.nextInt();
			sList.add(i-sIdx, i+1);
			// i-sIdx 들어갈 인덱스 번호
		}
		
		// 학생 순서 출력
		for(int s = 0; s < sList.size(); s++) {
			System.out.print(sList.get(s)+ " ");
		}
	}
}
