package JO1828_냉장고;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class JO1828_냉장고_서은효 {

	static int N;
	static int[][] arr;
	static int cnt; 
	static Stack<int[]> stack = new Stack<int []>();
	
	//정렬 후 
	//첫번째의 최고 온도를 다음 물질의 최저 온도와 비교했을 때
	//최저 온도가 최고 온도보다 낮다면 같은 냉장고 사용 가능 
	
	static void refrigerator() {
		
		int standard = arr[0][1];
		
		for(int i =0; i<N; i++) {
			if(standard < arr[i][0]) {
				standard = arr[i][1];
				cnt++;
			}
		}
		

	}
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;
		N = Integer.parseInt(bf.readLine());
		arr = new int[N][2];
		
		//배열에 삽입 
		for(int i =0; i<N; i++) {
			token = new StringTokenizer(bf.readLine());
			for(int j=0;j<2;j++) {
				arr[i][j] = Integer.parseInt(token.nextToken());
			}
		}
		
		
		//정렬
		Arrays.sort(arr,  new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
              return a[1]==b[1]? a[0]-b[0]: a[1]-b[1];
            }
        });

		
		
		refrigerator();
		System.out.println(cnt + 1);
	
		
		
	}
	
}


