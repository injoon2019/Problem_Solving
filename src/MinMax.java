//Baekjoon - 10818
import java.io.*;
import java.util.*;
public class MinMax {
	public static void main(String[] args)  throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 숫자의 갯수
        int tmpNum = Integer.parseInt(br.readLine());
        // 숫자를 받아오는 부분(공백으로 구분)
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        while (st.hasMoreTokens()) {
            int tmpNowNum = Integer.parseInt(st.nextToken());

            min = Math.min(min, tmpNowNum);
            max = Math.max(max, tmpNowNum);
        }
        System.out.println(min + " " + max);		
		
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		int N = Integer.parseInt(br.readLine());
//		ArrayList<Integer> al = new ArrayList<Integer>();
//		String[] strToken = br.readLine().split(" ");
//		int input;
//		for(int i=0; i<N; i++) {
//			input = Integer.parseInt(strToken[i]);
//			al.add(input);
//		}
//		Collections.sort(al);
//		System.out.println(al.get(0)+" "+al.get(N-1));
//		
	}
}
