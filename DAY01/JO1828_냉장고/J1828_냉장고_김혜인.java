import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class J1828_�����_������ {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); 
		int arr[][] = new int[N][2];

		
		for(int i=0; i<N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		 Arrays.sort(arr, new Comparator<int[]>() {
	            @Override
	            public int compare(int[] a, int[] b) {
	              return a[1]==b[1]? a[0]-b[0]: a[1]-b[1];
	            }
	        });

		/* ó���� ȸ�ǽ� ���Ѵ�� �ּڰ� �Ϸ��ٰ� ����
		int time = 0;
		int count = 1;
		for(int i=0; i<N; i++) {
			if(arr[i][0] >= time) {
				time = arr[i][1];
				count ++;
			}
		}System.out.println(count); */
		 
		//�ִ񰪰� �� ���� ��
		 
		int max = arr[0][1];
		int count = 1;
		
		for(int i=0; i<N; i++) {
			if(max<arr[i][0]) {
				max = arr[i][1];
				count++;
			}
		}
		System.out.println(count);
	}
}
		