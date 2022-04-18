import java.util.NoSuchElementException;
import java.util.Scanner;

class Node<E> {
    private Node<E> prev;
    private E data;
    private Node<E> next;
 
    public Node(E data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
 
    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }
 
    public Node<E> getPrev() {
        return this.prev;
    }
 
    public E getData() {
        return this.data;
    }
 
    public void setNext(Node<E> next) {
        this.next = next;
    }
 
    public Node<E> getNext() {
        return this.next;
    }
}

class Doublylinkedlist<E> {
    private Node<E> head;
    private Node<E> tail;
    int size = 0;
 
    public void insertFirst(E data) {
        Node<E> node = new Node<E>(data);
        //아무 노드가 없다
        if(head == null) {
            head = node;
            tail = node;
        }
        //노드가 있다면
        else if(head != null) {
            node.setNext(head); //다음노드를 head로 세팅 
            head.setPrev(node); //서로서로 가리키게
            head = node;
        }
        size++;
    }
 
    public void insertMiddle(int index, E data) {
        Node<E> node = new Node<E>(data);
        Node<E> current = getNode(index);
        Node<E> previous = current.getPrev();
        
      //인덱스상 앞에노드가 없을때
        if(head.getNext() == null || index == 1) 
            insertFirst(node.getData());
        
      //인덱스상 맨 마지막에 넣을때 
        else if(index == size+1)
            insertLast(node.getData());
 
        //중간에 넣을때 2번 자리에 넣으면 두번째 자리에 들어 
        else {
            node.setNext(previous.getNext());
            previous.setNext(node);
            node.setPrev(current.getPrev());
            current.setPrev(node);
        }
        size++;
    }
 
    public void insertLast(E data) {
        Node<E> node = new Node<E>(data);
//        뒤가 없을때  
        if(tail == null)
            insertFirst(node.getData());
 
        else {
            Node<E> current = getNode(size);
            current.setNext(node);
            node.setPrev(current);
            tail = node;
        }
        size++;
    }
 
    public void deleteFirst() {
//    	앞이 없을때 
        if(head == null) {
            System.out.println("삭제할 노드가 없습니다.");
            throw new NoSuchElementException();
            
        }
// 하나있을때 
        else if (size == 1) {
            head = null;
            tail = null;
        }
        else {
            Node<E> oldNode = head;
            head = oldNode.getNext();
            oldNode.getNext().setPrev(null);
            size--;
        }
    }
 
    public void deleteMiddle(int index) {
        Node<E> oldNode = getNode(index);
//        1번 지우라할때 
        if(index == 1)
            deleteFirst();
// 사이즈랑 인덱스같으면 맨뒤 
        else if(index == size)
            deleteLast();
// 중간일때 
        else {
        	if(oldNode.getNext()==null) {
            	deleteFirst();
            }
            Node<E> nextNode = getNode(index+1);
            Node<E> prevNode = getNode(index-1);
            
            prevNode.setNext(oldNode.getNext());
            nextNode.setPrev(oldNode.getPrev());
            size--;
        }
    }
 
    public void deleteLast() {
//    남은 노드가없을때 
        if(tail == null) {
            System.out.println("삭제할 노드가 없습니다.");
            return;
        }
//  한개있을때 
        else if (size == 1) {
            head = null;
            tail = null;
        }
 
//        그외 
        else {
            Node<E> oldNode = tail;
            Node<E> prevNode = oldNode.getPrev();
 
            tail = prevNode;
            prevNode.setNext(null);
            size--;
        }
    }
 
    public Node<E> getNode(int index) {
        if(index < size/2) {
            Node<E> current = head;
            for(int i=0; i<index; i++) {
                current = current.getNext();
            }
            return current;
        }
        else {
            Node<E> current = tail;
            for(int i=size-1; i>=index; i--) {
                current = current.getPrev();
            }
            return current;
        }
    }
 
    public void printList() {
        Node<E> current = head;
        if(current == null) {
            System.out.println("Empty List.");
            return;
        }
        while(current.getNext() != null) {
            System.out.print( current.getData() + " ");
            current = current.getNext();
        }
        System.out.print(current.getData());
        System.out.println();
    }
    
    public int search(E target) {
    	Node<E> nows = head;
    	int i=1;
        if(nows == null) {
            return -1;
        }
        while(nows.getNext() != null) {
            
            if(nows.getData().equals(target)) {
            	return i;
            }
            i+=1;
            nows = nows.getNext();
        }
        if(nows.getData().equals(target)) {
        	return i;
        }
        
        return -1;
    }

    
}


public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Doublylinkedlist<String> dlist = new Doublylinkedlist<>();
//		생성 

		int b;
		String a;
	
		Scanner sc = new Scanner(System.in);
		while(true) {
			
			a= sc.nextLine();
			
			
			if (a.equals("print")){
				
				dlist.printList();
				
			}
			else {
				b=dlist.search(a);
				
				if (b==-1) {
					dlist.insertLast(a);
				
				}
				else if(b==-2) {
					dlist.deleteLast();
				}
				else {
					System.out.println(b);
					dlist.deleteMiddle(b);
					
				}
				
			}
			
			
		}
		
	}

}

