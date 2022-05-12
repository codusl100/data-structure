import java.lang.Comparable;
import java.util.Scanner;

public class main {
	Scanner sc = new Scanner(System.in);
	public Integer[] init(int range) {
		Integer[] arr = new Integer[range];
		System.out.println("8개의 서로 다른 숫자를 입력하세요: ");
		for(int i=0;i<arr.length;i++) {
			arr[i]=sc.nextInt(); //arr 배열 인스턴스에 number 항목에 키보드 입력 받음
		}
		return arr;
	}
	public static void INSERT(Comparable[] a) {
		int N = a.length;
		for(int i = 1; i < N; i++) { // i는 현재 원소의 인덱스 
			for (int j = i ; j > 0 ; j --) { // 현재 원소를 정렬된 앞부분에 삽입
				if ( isLess(a[j], a[j-1]) ) // j번째 index 기준으로 앞 (왼쪽 index) 항들과 크기 비교.
					swap(a, j, j-1); // 작다면 swap 처리
				else break;
			}
		}
		System.out.print("삽입 정렬 결과 : [");
		for(int k=0; k<a.length;k++) {
			System.out.print(a[k]+" ");
		}
		System.out.print("]");
		System.out.println("\n");
	}
	public static void SHELL(Comparable[] a){
		int N = a.length;
		int h = 4; // 3x+1 간격: 1, 4, 13, 40, 121,... 중에서 4와 1만 사용
		while ( h >= 1) {
			for (int i = h; i < N; i++) { // h - 정렬 수행
				for (int j = i; j >= h && isLess(a[j], a[j-h]); j -= h) {
					swap(a, j, j-h);
				}
			}
			h /= 3;
		}
		System.out.print("셸 정렬 결과 : [");
		for(int k=0; k<a.length;k++) {
			System.out.print(a[k]+" ");
		}
		System.out.print("]");
		System.out.println("\n");
	}
	private static boolean isLess(Comparable u, Comparable v) {
		return(u.compareTo(v) < 0);
	}
	private static void swap(Comparable[] arr, int i, int j) {
		Comparable temp = arr[i];
		arr[i] = arr[j];
		arr[j] =temp;
	}
	public static void main(String[] args) {
		main insert = new main(); //insert 객체 생성
		Integer[] insertarr = insert.init(8); // 삽입 정렬할 배열 생성
		Integer[] shellarr = insert.init(8); // 셸 정렬할 배열 생성
		
		// 삽입 정렬
		INSERT(insertarr);
		// 셸 정렬
		SHELL(shellarr);
	}

}
