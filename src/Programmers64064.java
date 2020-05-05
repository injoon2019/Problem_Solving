//Programmers - 64064 �ҷ� ����� 
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
			//���Խ��� ����ϱ� ���� *�� . �� �ٲپ��ش�
			//���ԽĿ��� .�� ��� ���� �ϳ��� �ǹ��Ѵ�
			bannedRegex[i] = banned_id[i].replace("*", ".");
		}
		
		dfs(0, new HashSet<>());

		return resultSet.size();
	}
	
	//dfs�� ����ؼ� ���� ���̵� ����Ʈ ����� ������ ��, Set�� ����ؼ� �ߺ��� �����Ѵ�
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