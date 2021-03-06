//Programmers - 64061 (2019 카카오 개발자 겨울 인턴쉽 - 튜플)
import java.io.*;
import java.util.*;

public class Programmers64065 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int[] answer = {};
		
		s = s.substring(1,s.length()-1);
		s = s.replaceAll("\\}\\,\\{", "#");
		s = s.substring(1, s.length()-1);
		
		String[] arrS = s.split("#");
		
		Map<Integer, Object> map = new TreeMap<>();
		
		for(int i=0; i<arrS.length; i++) {
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
		System.out.println(answer);
	}
}