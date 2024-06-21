import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int M = 0; // 최댓값
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			if(M < nums[i]) {
				M = nums[i];
			}
		}
		
		double num = 0;
		
		for(int i = 0; i < N; i++) {
			num += (double)nums[i]/M*100;
//			System.out.println(num);
		}
		
		double result = num/N;
		System.out.println(result);
	}
}
