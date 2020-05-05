//Programmers - 64064 불량 사용자 
//https://hoho325.tistory.com/169
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Programmers64064 {
	static String[] userId;
	static String[] bannedRegex;
	static boolean[] checked;
	static HashSet<HashSet<Integer>> resultSet;
	
	public static void main(String[] args)throws Exception{
		String[] user_id = {"frodo", "crodo", "abcd123"};
		String[] banned_id = {"*rodo"};
		System.out.println(solution(user_id, banned_id));
	
	}	
	
	public static int solution(String[] user_id, String[] banned_id) {
		userId = user_id;
		checked = new boolean[user_id.length];
		resultSet = new HashSet<>();
		bannedRegex = new String[banned_id.length];
		for(int i=0; i<banned_id.length; i++) {
			//정규식을 사용하기 위해 *를 . 로 바꾸어준다
			//정규식에서 .은 모든 문자 하나를 의미한다
			bannedRegex[i] = banned_id[i].replace("*", ".");
		}
		
		dfs(0, new HashSet<>());

		return resultSet.size();
	}
	
	//dfs를 사용해서 제제 아이디 리스트 목록을 구해준 뒤, Set을 사용해서 중복을 제거한다
	public static void dfs(int index, HashSet<Integer> set) {
		if(index == bannedRegex.length) {
			resultSet.add(set);
			return;
		}
		
		for(int i=0; i<userId.length; i++) {
			if(Pattern.compile(bannedRegex[index]).matcher(userId[i]).matches()
					&& !checked[i]) {
				checked[i] = true;
				set.add(i);
				
				dfs(index+1, new HashSet<>(set));
				checked[i] = false;
				set.remove(i);
			}
		}
	}
	
}