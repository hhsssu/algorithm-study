import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = 0;
		int max = Integer.MIN_VALUE;
		int maxIdx = -1;
		for (int i = 1; i <= 9; i++) {
			num = Integer.parseInt(br.readLine());
			if(num > max) {
				max = num;
				maxIdx = i;
			}
		}
		
		System.out.println(max);
		System.out.println(maxIdx);
	}
}
