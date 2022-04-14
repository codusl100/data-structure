import java.util.Scanner;
import java.util.NoSuchElementException;
class Node<E>{ //노드 클래스
	private E	    item; //노드 내부 담고 있는 item 변수
	private Node<E> next; //다음 노드를 가리키는 레퍼런스 변수 (노드 자체를 가리키므로 Node<E> 타입 지정)
	private Node<E> prev; //이전 노드를 가리키는 레퍼런스 변수 (노드 자체를 가리키므로 Node<E> 타입 지정)
	public Node(E Item) {//생성자
		this.item = Item;
		this.next = null;
		this.prev = null; //가리키는 노드 없이 null 처리
	}
	//get과 set 메소드들
	public E	   getItem() {return item;}
	public Node<E> getNext() {return next;}
	public Node<E> getPrev() {return prev;}
	public void    setItem(E newItem)		{ item = newItem; }
	public void    setNext(Node<E> newNext) { next = newNext; }
	public void	   setPrev(Node<E> newPrev) { prev = newPrev; }
}

//이중연결리스트로 구현한 DList 클래스
class DList<E>{
	private Node<E> head = new Node<E>(null); //연결 리스트 노드의 첫 부분
	private Node<E> tail = new Node<E>(null); //연결 리스트 노드의 마지막 부분
	private   int  size = 0; //담긴 노드 요소 개수
	public DList() { //생성자
		head.setPrev(tail); //맨 처음 노드 = head
		tail.setNext(head); //맨 마지막 노드 = tail
		this.size = 0; //이중연결리스트에 연결된 노드의 개수
		//처음 리스트 생성시 아무런 데이터 없으므로 null, 0으로 초기화
	}

// 탐색, 삽입, 삭제 연산을 위한 메소드 선언
//탐색 기능
public int search(E target) { //target이 속한 index를 탐색
	Node<E> p = head;
	for (int k = 0; k < size ; k++) {
		if(p.getItem() == target) return k;
		p = p.getNext(); //다음 노드로
	}
	return -1; //탐색을 실패한 경우 -1 리턴	
	}

public Node<E> getNode(int index){ //해당 index의 target값 가져옴
	Node<E> node;
	if(index< size/2) { //중간 기준으로 앞 부분 탐색
		node = head;
		for(int i=0; i<index;i++) {
			node = head.getNext();
		}
	}
	else {
		node = tail; //중간 이후부터 tail서부터 앞으로 탐색
		for(int i=size-1;i>index;i--) {
			node = node.getPrev();
		}
	}
	return node;
}

//출력
public String toString() { //노드 아이템들을 string으로 변환하여 출력
	Node<E> node = head;
	if(head == null) {
		System.out.println("해당되는 노드가 없습니다");
	}
	String str="";
	while(node.getNext()!=null) //다음 노드 없을 때까지
	{
		str += node.getItem() +" ";
		node = node.getNext();
	}
	str += node.getItem();
	return str + " ";
}

//삽입
public E addNode(E newItem) { //연결리스트 맨 앞에 새 노드 삽입
	Node<E> newnode = new Node<E>(newItem); //새 노드 생성
	if(newnode.getItem()== null)
		return null;
	newnode.setItem(newItem); //newnode에 newItem 담아줌
	if(size == 0) {
		// 리스트의 size가 0인 경우
		tail.setPrev(newnode); //tail 노드 이전에 newnode 추가
		newnode.setNext(tail); //newnode 다음 노드는 tail 노드
		head.setNext(newnode); //head 노드 다음은 newnode
		newnode.setPrev(head); //newnode 이전 노드는 head 노드
		size++; //리스트 사이즈 추가
	}
	else { //리스트 size가 0이 아닌 경우
		//임시 노드 N이 가리키는 노드의 다음에 삽입할 것
		Node<E> N = tail.getPrev(); //임시 리스트 생성
		tail.setPrev(newnode); //tail의 이전 노드는 newnode
		newnode.setNext(tail); //newnode의 다음 노드는 tail
		newnode.setPrev(N); //newnode의 이전 노드는 N(임시 노드)
		N.setNext(newnode); //임시 노드의 다음 노드는 newnode
	size++; //노드 요소 개수 추가
	
	}
	return newItem;
}
public void deleteNode(E Item) { //리스트의 노드 삭제
	Node<E> node = new Node(Item); //제거할 노드 가리키기 위해 node 노드 생성
	 //node는 Item을 담음
	if(node==null) //가리키는 노드가 없다면
		head= node.getNext();
	node.getPrev().setNext(node.getNext()); //제거할 node 노드의 이전 노드가 다음 노드를, node 노드의 다음노드로 가리킨다.
	node.getNext().setPrev(node.getPrev()); //제거할 node 노드의 다음 노드가 이전 노드를, node 노드의 이전노드로 가리킨다.
	node.setNext(null); //node의 다음 노드는 null로 설정
	node.setPrev(null); //node의 이전 노드는 null로 설정
	node.setItem(null); //node가 담는 item은 null로 설정
	size--; //리스트 사이즈 줄음
}

public boolean contains(E item) { //노드에 item 존재 여부 반환
	return search(item)!=-1; //search시 -1이 안나오면 true
}

public int size() { //노드 사이즈 return 
	return size;
}

}
public class main{
	public static void main(String[] args) {
		DList<String> Name = new DList<>();
		DList<Integer> Num = new DList<>();
		Scanner sc = new Scanner(System.in);
		while(true) {
			String name=sc.next(); 
			if(name.equals("print")) break; //print입력시 while문 종료
			Name.addNode(name); //Name 리스트에 입력받은 name 추가
			
			int number=sc.nextInt();
			Num.addNode(number); //Num 리스트에 입력받은 number 추가
			
			for(int i=0;i<Name.size();i++) {
			if(Name.contains(name))
				Name.deleteNode(name);
			
			else if(Num.contains(number))
				Num.deleteNode(number);
			}
			
		}
		
		System.out.println(Name.toString());
		System.out.println(Num.toString());

	}
}
