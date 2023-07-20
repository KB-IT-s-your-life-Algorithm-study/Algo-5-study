package 비밀지도;

public class P비밀지도_조성환 {
	public static void main(String[] args) {

		int[] arr1 = new int[] { 9, 20, 28, 18, 11 };
		int[] arr2 = new int[] { 30, 1, 21, 17, 28 };

		System.out.println(solution(5, arr1, arr2));
	}

	static String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];

		for (int i = 0; i < n; i++) {
			String wall = "";
			String bin_1 = "";
			String bin_2 = "";
			String bin1 = Integer.toBinaryString(arr1[i]);
			String bin2 = Integer.toBinaryString(arr2[i]);
			if (bin1.length() < n) {
				for (int j = 0; j < n-bin1.length(); j++) {					
					bin_1 += '0';
				}
			}
			
			if (bin2.length() < n) {
				for (int j = 0; j < n-bin2.length(); j++) {					
					bin_2 += '0';
				}
			}
			
			bin_1 += bin1;
			bin_2 += bin2;
			for (int j = 0; j < n; j++) {					
				if(bin_1.charAt(j) == '1' || bin_2.charAt(j) == '1') {
					wall += "#";
				}else {
					wall += " ";
				}
			}
			answer[i] = wall;
			
		}
		return answer;
	}
}
