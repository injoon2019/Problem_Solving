//Baekjoon - 1676
//https://ksj14.tistory.com/entry/BackJoon1676-%ED%8C%A9%ED%86%A0%EB%A6%AC%EC%96%BC-0%EC%9D%98-%EA%B0%9C%EC%88%98
/*
 * 0을 만들기 위해서는 2와 5가 필요하다. 5는 2보다 훨씬 적게 나타나며 결론적으로 5가 몇번 나타는지가 관건이다.
 * 주의해야할 점은 25 같은 경우는 5가 두번 나타는 경우이다.
 * 따라서 n의 범위는 500까지 이므로 
 * 5로 한번 나눠서 5가 몇번 나타나는지, 25로 나눠서 25가 몇번 나타나는지.. 카운팅하면된다. 
 * */
import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class BaekJoon1676 {


	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int ans = n / 5 + n / 25 + n / 125;

		System.out.println(ans);
	}	
}