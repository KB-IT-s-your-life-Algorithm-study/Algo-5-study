class Solution {
    	static int answer;
	
	public static void DFS(int[] number, int target, int depth, int sum) {
		if(number.length == depth) {
			if(sum == target) {
				answer++;
			}
		}
		else {
			DFS(number, target, depth+1, sum + number[depth] );// + 
			DFS(number, target, depth+1, sum - number[depth] );// -
			
		}
	}
    public int solution(int[] numbers, int target) {
    	DFS(numbers, target, 0, 0);
        return answer;
    }
}