import java.util.Scanner;
import java.lang.StringBuilder;
import java.util.EmptyStackException;
class Stack<E>{
	private E s[]; // 스택을 위한 배열
	int top; // 스택의 top 항목의 배열 원소 인덱스
	private int size; // 스택의 사이즈
	public Stack() { // 스택 생성자
		s = (E[]) new Object[1]; //초기에 크기가 1인 배열 생성
		top = -1;
		size = 0;
	}
	public int size() {return top+1;} //스택에 있는 항목의 수를 리턴
	public boolean isEmpty() {return (top == -1);}	//스택이 empty이면 true 리턴
	//peak(), push(), pop(), resize() 메소드 선언


public E peek() { //스택 top 항목만의 내용만을 리턴
	if (isEmpty())
		return null; //비었다면 null 처리
	return s[top];
}	

public void push(E newItem) { // push 연산
	if(size() == s.length)
		resize(2*s.length); //스택을 2배의 크기로 확장
	s[++top] = newItem; //새 항목을 push
}

public E pop() { // pop 연산
	if(isEmpty()) throw new EmptyStackException(); //underflow시 프로그램 정지
	E item = s[top];
	s[top--] = null; //null로 초기화
	if(size()>0 && size()==s.length/4)
		resize(s.length/2); //스택을 1/2 크기로 축소
	return item;
}

public void resize(int length) { // stack resize
	  E b[] = (E[]) new Object[length];
      for(int i=0; i<top+1; i++) 
    	  {b[i] = s[i];
    	  s = b;}
}


}

public class main {
	public static int order(char c) {//연산자 우선 순위 비교
		switch(c) {
			case '*':
			case '/':
				return 2;
			case '+':
			case '-':
				return 1;
			default:
				return 0;
		}
	}
	public static String change(String str) {
		Stack<Character> stack = new Stack<>();
        String sum = ""; //출력할 문자열
        
        for (int i=0;i<str.length();i++) {  
        	char c = str.charAt(i); //입력받은 문자
        	//입력받은 c가 영문자면
        	if(Character.isAlphabetic(c)) {
        		sum+=c; //후위표기식 sum에 바로 추가
        	}
        	//stack이 비었다면
        	else if(stack.isEmpty()) {
        		stack.push(c);
        	}
        	//입력받은 c가 열린 괄호라면
        	else if(c == '(' || c == '{') {
        		stack.push(c);
        	}
        	//입력받은 c가 닫힌 괄호라면
        	else if(c == ')' || c == '}') {
        			while(!stack.isEmpty()&&(stack.peek() != '(' || stack.peek() != '{') ) { //stack이 빌 때까지 && stack 최상위값이 열린 괄호 나올 때까지
        				sum += stack.pop(); //stack pop값을 후위계산식에 더해준다
        			}
        		}
        	//나머지 입력받은 연산자
        	else { //입력한 c와 우선순위를 비교하여 c보다 크다면
        			while(!stack.isEmpty() && order(stack.peek())>=order(c)) 
        				sum += stack.pop(); //stack의 상위값을 제거해서 후위표기식에 입력함
        				//stack이 다 비었다면 우선순위가 낮은 c를 stack에 넣어줌
        				stack.push(c);
        			}
        		}
        		 while (!stack.isEmpty()) { // stack에 남아 있는 것들 후위표기식 sum에 추가하기
                     sum+=stack.pop(); 	
        		 } 	//)를 삽입하고 stack에 담겨져있는게 다 꺼내져와야하는데 *가 안나오고 null처리가 됩니다..

        	     System.out.print("최종후위표기식: ");	
        	   //** stack.peek()값이 null일 때 처리를 못해서 에러가 뜹니다..
				return sum;
	}
	
	public static int calculate(String str) {
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<str.length();i++) {
			char c = str.charAt(i);
			if(c =='+'||c =='-'||c =='*'||c =='/'){//연산자라면
				int num1 = stack.pop(); //stack에 순서대로 저장한 정수들 pop한 num1, num2
				int num2 = stack.pop();
				switch(c) { 
				case '+': //더하기면 pop한 num1, num2 값을 더해서 stack에 push
					int tmp1 = num1+num2;
					stack.push(tmp1);
					break;
				case '-': //빼기면 pop한 num1, num2 값을 빼서 stack에 push 
					int tmp2 = num2-num1;
					stack.push(num2-num1);
					break;
				case '*': //곱하기면 pop한 num1, num2 값을 곱해서 stack에 push
					int tmp3 = num1*num2;
					stack.push(num1*num2);
					break;
				case '/': //나누기면 pop한 num1, num2 값을 나눠서 stack에 push
					int tmp4 = num2/num1;
					stack.push(tmp4);
					break;
				}
			}
			else if(c>='0'&&c<='9') { //c가 정수라면
				stack.push(c-'0'); //stack에 push
				// 0 뺴는 이유: 정수형으로 만드려고
			}
		}
		System.out.print("후위표기식 계산 결과: ");
		return stack.pop(); //최종적으로 계산하여 stack에 저장해둔 마지막 값을 출력
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//1. 중위표기법 -> 후위표기법 변환
		//String str= sc.next();
        //System.out.println(change(str)); //에러 떠서 밑에 함수가 구현이 안되는 경우 주석 처리 부탁드립니다
        //2.중위표기법 -> 후위표기법 계산
        //String str2= sc.next();
        //System.out.println(calculate(str2));
		//1번, 2번에서 마찬가지로 일정 문자열 수 이상으로 올라가면 nullpointerexception 에러가 뜹니다..
	} 
	}
