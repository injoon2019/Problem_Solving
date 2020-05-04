//Programmers - 64061 (2019 카카오 개발자 겨울 인턴쉽 - 튜플)
import java.io.*;
import java.util.*;

public class Programmers64065 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int[] answer = {};
		
		s = s.substring(1, s.length()-1);	//1번 인덱스부터 s.length()-1 인덱스 전까지
		s = s.replaceAll("\\}\\,\\{", "#");	//},{를 #으로 대체한다
		s = s.substring(1, s.length()-1);	//남아있는 앞뒤의 마지막 괄호를 제거한다
		
		String[] arrS = s.split("#");
		
		//이제 문자열 크기가 가장 작은 것부터 순서대로 LinkedHashSet에 넣어준다
		//문자열 크기가 가장 작은 대상을 기록한다
		Map<Integer, Object> map = new TreeMap<>();
		for(int i=0;  i<arrS.length; i++) {
			String[] tuple = arrS[i].split(",");
			map.put(tuple.length, tuple);
		}
		
		Iterator mapItr = map.keySet().iterator();
		
		Set<Integer> set = new LinkedHashSet<>();
		
		while(mapItr.hasNext()) {
			int key = (int)mapItr.next();
			String[] arr = (String[])map.get(key);
			
			for(String tuple: arr) {
				set.add(Integer.valueOf(tuple));
			}
		}
		
		answer = new int[set.size()];

		Iterator setItr = set.iterator();
		int index = 0;
		
		while(setItr.hasNext()) {
			answer[index] = (int)setItr.next();
			index++;
		}
		
		
		System.out.println(s);
	}	
}