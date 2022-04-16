import java.util.Scanner;
import java.util.NoSuchElementException;
class CircularDeque <E> {
	private E item; //노드 내부 담고 있는 item 변수
	private Node front; //가장 앞에 있는 front 노드 가리키는 레퍼런스 변수
	private Node rear; //가장 뒤에 있는 rear 노드 가리키는 레퍼런스 변수
	private int size; //노드 개수
	
	class Node<E>{
		private E item;
		
		public Node(E item) {
			this.item = item;
			prev = null;
			next = null;
		}
		private Node prev, next;
	}
	
	public CircularDeque() {
		front = null;
		rear = null;
		size = 0;
	}
public int	   size()	 {return size; }
public boolean isEmpty() {return size() == 0;} //큐가 empty면 true 리턴
//add, remove 메소드 선언
public void add_front(E newItem) {
	Node newNode = new Node(newItem); // 새 노드 생성
	if(isEmpty()) {
		front = newNode; 
		rear = newNode; //deque가 empty면 front, rear은 newnode 가리킴
		}
	else {
		front.prev = newNode; //front 앞 자리는 newNode
		newNode.next = front; //newNode 다음 자리는 front
		front = newNode; //front를 newNode로 재설정
	}
	size++; //데크 size 추가
	
}
public void add_rear( E newItem) {
	Node newNode = new Node(newItem);
	if(isEmpty()) {
		front = newNode;
		rear = newNode;
	}
	else {
		rear.next = newNode;
		newNode.prev = rear;
		rear = newNode;
	}
	size++;
}
public E delete_front() {
	if(isEmpty()) {
		return null;
	}
	E ret = (E)front.item;
	if(front.next==null) {
		front = rear = null;
	}
	else {
		front = front.next;
		front.prev = null;
	}
	size --;
	return ret;
}
public E delete_rear() {
	if(isEmpty()) {
		return null;
	}
	E ret = (E)rear.item;
	if (rear.prev == null) {
		front = rear = null;
	} else {
		rear = rear.prev;
		rear.next = null;
	}
	size--;
	return ret;
}
public int get_front() {
	return (int) front.item;
}
public int get_rear() {
	return (int) rear.item;
}
public int get_size() {
	return size;
}

}

public class main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircularDeque<Integer> c = new CircularDeque<>();
		c.add_front(10);
		c.add_front(3);
		c.add_rear(5);
		System.out.println(c.get_size());
		System.out.println(c.isEmpty());
		System.out.println(c.delete_front());
		System.out.println(c.delete_rear());
		System.out.println(c.delete_rear());
		System.out.println(c.isEmpty());
	}

}
