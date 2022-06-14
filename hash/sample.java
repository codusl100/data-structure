import java.util.Random;
import java.util.Scanner;
public class Chaining<K, V> {
	private static int M = 13; //테이블 크기
	private static Node[] a = new Node[M]; //해시 테이블
	public static class Node { // Node 클래스
		private Object key;
		private Object data;
		private Node next;
		public Node(Object newkey, Object newdata, Node ref) { // 생성자
			key = newkey;
			data = newdata;
			next = ref;
		}
		public Object getKey()  { return key; }
		public Object getData() { return data;}
		
	}
	private int hash(K key) { // 해시 코드
		return (key.hashCode() & 0x7fffffff) % M; } // 나눗셈 연산
	
	private int hash2(K key) { // 해시 코드
		return (7- key.hashCode() & 0x7fffffff) % 7; } // 나눗셈 연산
	
	public V get(K key) { // 탐색 연산
		int i = hash(key);
		for (Node x = a[i]; x != null; x = x.next) // 연결리스트 탐색
				if (key.equals(x.key)) return (V) x.data; // 탐색 성공
		return null; //탐색 실패
	}
	
	private void put(K key, V data) { // 삽입 연산
		int i = hash(key);
		int j = hash2(key);
		int count=0; //첫번째 해시 함수
		if (a[i]==null) a[i] = new Node(i, data, null); // 연결 리스트의 첫 노드로 삽입
		else {
			for (Node x = a[i]; x != null; x = x.next)
				if (key.equals(x.key)) { // 이미 key 존재
					a[i]= new Node(i, data, a[i]);
					x.data = data;		 // 데이터만 갱신
					return ;
				}
			}
		/*for (Node x = a[j]; x != null; x = x.next)
					if (key.equals(x.key)) { // 이미 key 존재
						a[j]= new Node(j, data, a[j]);
						x.data = data;		 // 데이터만 갱신
						return ;
					}*/
		
	}
	
	 public void print() {
		 System.out.print("random number table : \n");
			for (int i=0; i<a.length;i++){
				System.out.print(a[i]==null?null+"-->": "{ key: "+a[i].getKey()+" } -->");
				System.out.println();
			for (Node x = a[i]; x!=null; x = x.next) {
				System.out.print(a[i]==null? null+" ": " { data: "+a[i].getData()+" } ");
				
					System.out.println("\n");
			}
			}
		}
	    // 해시함수는 각각 %13, 7-(key%7)
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random(); // 랜덤 객체 생성
		Chaining table = new Chaining<>();
		for(int i=0; i< rand.nextInt(13)+1; i++) {
			int random = rand.nextInt(20)+1;
			table.put(random, "randomvalue");
		}
		table.print();
		System.out.print("random integer: ");
		
		System.out.println("\n");
		
		int input = 1;
		String inputkey="";
		while(input!=0) {
			input = sc.nextInt(); // 사용자 입력 숫자
			inputkey = sc.next();
			table.put(input, inputkey);
			table.print();
			}
			
		}
		}
