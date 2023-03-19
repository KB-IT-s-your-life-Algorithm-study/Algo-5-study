package B1940_주몽;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1940_주몽_서은효 {

	static int N; 
	static int M;
	static int [] arr;
	static int cnt;
	
	static void find(int m) {
		for(int i =0,len=arr.length;i<len;i++) {
			for(int j=i+1;j<len;j++) {
				if((arr[i]+arr[j]) == m) {
					cnt++;
				}
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N= Integer.parseInt(bf.readLine());
		M= Integer.parseInt(bf.readLine());
		arr=new int[N];
		StringTokenizer token = new StringTokenizer(bf.readLine());
		
		for(int i =0; i<N;i++)arr[i] = Integer.parseInt(token.nextToken());
		
		find(M);
		System.out.println(cnt);
		
		
	}

}
