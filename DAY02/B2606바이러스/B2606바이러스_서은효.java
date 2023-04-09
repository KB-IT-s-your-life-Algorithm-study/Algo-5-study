package B2606바이러스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2606바이러스_서은효 {
	static int computer;
	static int pair;
	static ArrayList<Integer> [] graph;
	static boolean [] isVisited;
	static int cnt; 
	
	public static void DFS(int nowNode) {

		if(isVisited[nowNode]) return;

		isVisited[nowNode] = true;
		cnt++;
		for(int nextNode : graph[nowNode]) {
			DFS(nextNode);

		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;
		
		computer = Integer.parseInt(bf.readLine())+1;
		pair = Integer.parseInt(bf.readLine());
		
		graph = new ArrayList[computer];
		isVisited = new boolean[computer];
		
		for(int i =0; i<computer; i++) graph[i]= new ArrayList<>();
		
	
		for(int i =0; i<pair; i++) {
			token = new StringTokenizer(bf.readLine());
			
			int u = Integer.parseInt(token.nextToken());
			int v = Integer.parseInt(token.nextToken());
			
			graph[u].add(v);
			graph[v].add(u);

		}
		System.out.println(Arrays.toString(graph));
		
		DFS(1);
		System.out.println(cnt-1);
		
		
		
		
	}
}
