package EX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1940_주몽_조성환 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		int[] steel = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			steel[i] = Integer.parseInt(st.nextToken());
		}
		int cnt = 0;
		
		// 겹치는걸 찾아라
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 재료 하나로 만드는 건 불가
				if (steel[i] != 0 && steel[j] != 0) {
					// 자기 자신은 제외
					if (steel[i] + steel[j] == M && i != j) {
						cnt++;
						steel[i] = 0;
						steel[j] = 0;
					}
				}
			}
		}
		System.out.println(cnt);
	}

}
