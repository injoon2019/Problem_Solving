//Programmers - 64064 �ҷ� ����� 
//https://hoho325.tistory.com/169
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Programmers64064 {
	static int ans;
	static ArrayList<ArrayList> list;
	
	public static void main(String[] args)throws Exception{
		String[] user_id = {"frodo", "crodo", "abcd123"};
		String[] banned_id = {"*rodo"};
		System.out.println(solution(user_id, banned_id));
	
	}	
	
	public static int solution(String[] user_id, String[] banned_id) {
		boolean[] visited = new boolean[user_id.length];
		list = new ArrayList<>();
		dfs(banned_id, user_id, 0, 0, visited);
		return ans;
	}
	
	public static void dfs(String[] banned_id, String[] user_id, int idx, int n, boolean[] visited) {
		//������ ���̵� ����� ��� �˻��ߴٸ�
		if(n== banned_id.length) {
			//user_id �� ���� ������ ���̵� �̾Ƽ� temp�� �ֱ�
			ArrayList<String> temp = new ArrayList<>();
			for(int i=0; i<visited.length; i++) {
				if(visited[i]) {
					temp.add(user_id[i]);
				}
			}
			
			//������ ���̵� ����Ʈ�� ����� ����Ʈ�鿡 ���ؼ� ���� ����Ʈ�� �ִ��� Ž���Ѵ�
			//���� ����Ʈ �� �ϳ��� �̾Ƽ� �� ����Ʈ �ȿ� �ִ� ���ҵ�� ��� ���� ���ҵ��� ���� temp ����Ʈ�� ���ҿ� ��
			//�������� �ʴ°� �ϳ��� �ִٸ� flag�� true�� �ǰ�, cnt�� ������Ų��
			//�׷��� �ؼ� cnt�� list�� ũ��� ���� ���ٸ�, ���ݱ��� ������� ������ ����Ʈ�� ��ġ�� ����Ʈ�� ���ٴ� ��
			//�׷��Ƿ� ������ ����Ʈ ��(ans)�� ������Ű�� ������ ����Ʈ ��Ͽ� ��� ���� temp����Ʈ�� �߰��Ѵ�
			int cnt = 0;
			for(int i=0; i<list.size(); i++) {
				ArrayList<String> t = list.get(i);
				boolean flag = false;
				for(int j=0; j<temp.size(); j++) {
					if(!temp.contains(t.get(j)))
						flag = true;
				}
				if(flag)
					cnt++;
			}
			if(cnt== list.size()) {
				list.add(temp);
				ans++;
			}
			return;
			
		}
		
		//��͸� ���� pattern�� �´� ���ڵ��� ������ ������
		for(int i=0; i<user_id.length; i++) {
			String s = banned_id[idx].replace("*", ".");
			Pattern pattern  = Pattern.compile(s);
			Matcher matcher = pattern.matcher(user_id[i]);
			
			//����ǥ���Ŀ� ��Ī�ǰ�, ���̰� ���� ���
			if(matcher.find() && user_id[i].length() == banned_id[idx].length()) {
				//���� ���̵�� üũ���� ���� ��� check
				if(!visited[i]) {
					visited[i] = true;
					dfs(banned_id, user_id, idx+1, n+1, visited);	//���� banned_id�� ���õǴ� ���� ���̵� ã��
					visited[i] = false;
				}
			}
			
		}
	}
}