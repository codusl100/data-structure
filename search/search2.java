import java.util.Random;
import java.util.Scanner;
public class search2 {
	public static void INSERT(int[] arr) { // 삽입정렬
		int N = arr.length;
		for(int i = 1; i < N; i++) { // i는 현재 원소의 인덱스 
			for (int j = i ; j > 0 ; j --) { // 현재 원소를 정렬된 앞부분에 삽입
				if ( isLess(arr[j], arr[j-1]) ) // j번째 index 기준으로 앞 (왼쪽 index) 항들과 크기 비교.
					swap(arr, j, j-1); // 작다면 swap 처리
				else break;
			}
		}
		System.out.print("삽입 정렬 결과 : [");
		for(int k=0; k<arr.length;k++) {
			System.out.print(arr[k]+" ");
		}
		System.out.print("]");
		System.out.println("\n");
	}
	private static boolean isLess(Comparable u, Comparable v) {
		return(u.compareTo(v) < 0);
	}
	private static void swap(int[] arr, int i, int j) {
		Comparable temp = arr[i];
		arr[i] = arr[j];
		arr[j] =(int) temp;
	}
	
	public static void binarysearch(int arr[], int low, int high, int target) {
		int mid = (low+high)/2;
		if(low == high) {
			if(arr[low]==target)
				System.out.println("탐색에 성공했습니다.");
			else 
				System.out.println("탐색에 실패했습니다.");
		}
		else {
			if(target == arr[mid])
				System.out.println("탐색에 성공했습니다.");
			else if(target < arr[mid])
				binarysearch(arr, low, mid-1, target);
			else if(target > arr[mid])
				binarysearch(arr, mid+1, high, target);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		Random rand = new Random(); // 랜덤 객체 생성
		int[] arr = new int [20]; // 20개의 배열 생성
		for(int i=0;i<arr.length;i++) {
			arr[i]= rand.nextInt(100)+1;
			for(int j=0;j<i;j++) {
				if(arr[i]==arr[j]) i--;
			}
			}
		
		INSERT(arr); // 삽입 정렬 사용
		
		System.out.print("탐색할 값을 입력하시오: ");
		int num2 = sc.nextInt();
		binarysearch(arr, 0, arr.length-1, num2);
		
		}

}
