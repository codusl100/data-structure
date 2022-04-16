import java.util.Scanner;
import java.util.NoSuchElementException;
class CircularDeque <E> {
	private E item; //노드 내부 담고 있는 item 변수
	private Node front; //가장 앞에 있는 front 노드 가리키는 레퍼런스 변수
	private Node rear; //가장 뒤에 있는 rear 노드 가리키는 레퍼런스 변수
	private int size; //노드 개수
	
	class Node<E>{  //Node 생성자
		private E item;
		public Node(E item) {
			this.item = item;
			this.prev = null;
			this.next = null;
		}
		private Node prev;
		private Node next;
	}
	
	public CircularDeque() { //CircularDeque 생성자
		front = null;
		rear = null;
		size = 0;
	}
	
public int	   size()	 {return size; } //size 메소드
public boolean isEmpty() {return size() == 0;} //큐가 empty면 true 리턴

//add, remove 메소드 선언
public void add_front(E newItem) { //front 노드 추가 메소드
	Node newNode = new Node(newItem); // 새 노드 생성
	if(isEmpty()) {
		front = newNode; 
		rear = newNode; //deque가 empty면 front, rear은 newnode 가리킴
		System.out.println(" ** 데크가 비어있습니다.");
		}
	else {
		front.prev = newNode; //front 앞 자리는 newNode
		newNode.next = front; //newNode 다음 자리는 front
		front = newNode; //front를 newNode로 재설정
	}
	size++; //데크 size 추가
}
public void add_rear( E newItem) { // rear 노드 추가 메소드
	Node newNode = new Node(newItem);
	if(isEmpty()) {
		front = newNode;
		rear = newNode;
		System.out.println(" ** 데크가 비어있습니다.");
	}
	else {
		rear.next = newNode;
		newNode.prev = rear;
		rear = newNode;
	}
	size++;
}
public E remove_front() { // front 노드 item 제거 메소드
	if(isEmpty()) 
		{
		System.out.println(" ** 데크가 비어있습니다.");
		return null;
		}
	E fitem = (E)front.item; //front 노드에 담겨있는 변수 = fitem
	if(front.next==null) { //front 노드 다음 노드가 null이라면
		front = null;
		rear = null; // front, rear 노드 모두 null
	}
	else {
		front = front.next;
		front.prev = null;
	}
	size --; //size 감소
	return fitem;
}
public E remove_rear() { // rear 노드 item 제거 메소드
	if(isEmpty()) {
		System.out.println(" ** 데크가 비어있습니다.");
		return null;
	}
	E ritem = (E)rear.item; //rear 노드에 담겨있는 변수 = ritem
	if (rear.prev == null) { //rear 노드의 이전 노드가 비어있다면
		front = null; 
		rear = null; //front, rear가 가리키는 노드 다 null
	} else { //비어있지 않다면
		rear = rear.prev;
		rear.next = null;
	} 
	size--; //size 감소
	return ritem;
}

public void peek() { //뒤에서부터 출력하는 메소드
	for(int i=0;i<size();i++) {
		System.out.print(rear.item+" "); //for문에서의 목적은 rear의 item 출력 
		rear=rear.prev; 
		//peek함수의 목적은 데크에 저장된 수들을 출력하는 것이기에 rear 자리 출력 후, 위치를 이전시키며 다시 출력한다. (반복)
	}	
}
public int returnFront() { //맨 앞 item 반환 메소드
	return (int) front.item;
}
public int returnRear() { //맨 뒤 item 반환 메소트
	return (int) rear.item;
}
}

public class main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircularDeque<Integer> c = new CircularDeque<>();
		Scanner sc = new Scanner(System.in);
		// 과제 1 : 문자열 뒤집기
		System.out.println("데크에 저장할 양수들을 입력하시오. (종료 원하면 0 혹은 음수 입력)");
		int input = 1;
		while(input>0) { //0 또는 음수 입력해서 입력 정지함
			input = sc.nextInt(); //사용자로부터 양수 입력받음
			c.add_rear(input); //c 데크에 input 입력 받음 
		}
		c.remove_rear(); //-1까지 데크에 저장되었기에 -1 제거
		System.out.print("데크에 저장된 양수: ");
		c.peek(); //데크 출력
		System.out.println();
	}

}
