import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static String a;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		List<String> list = new ArrayList<>();

		while (st.hasMoreTokens()) {
			a = st.nextToken();
			list.add(a);
		}

		System.out.println(list.size());
	}
}
