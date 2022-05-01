import java.lang.Comparable;
import java.util.Scanner;
// 퀵 정렬 가운데
class Quick{
		Scanner sc = new Scanner(System.in);
		public Integer[] init(int range) {
			Integer[] arr = new Integer[range];
			System.out.println("10개의 서로 다른 숫자를 입력하세요: ");
			for(int i=0;i<arr.length;i++) {
				arr[i]=sc.nextInt(); //arr 배열 인스턴스에 number 항목에 키보드 입력 받음
			}
			return arr;
		}
		
		public static void sort(Comparable[] arr) {
			sort(arr, 0, arr.length-1);
			
		}
		static void sort(Comparable[] arr, int low, int high) {
			if(high <= low) return;
			int j = partition(arr, low, high);
				System.out.print("정렬된 배열: [ ");
				for(int k=0; k<arr.length;k++) {
					System.out.print(arr[k]+" ");
				}
				System.out.print("]");
				System.out.println("\n");
				
			sort(arr, low, j-1); //피봇보다 작은 부분을 재귀호출
			sort(arr, j+1, high); //피봇보다 큰 부분을 재귀호출
			
		}
		private static int partition(Comparable[] arr, int low, int high) {
			int i = low;
			int j = high;
			int mid = (low + high)/2;
			Comparable p = arr[mid];
			while(i<j) {
				while(isLess(arr[i], p) && i<j) i++; //피봇과 같거나 작으면
				while(isLess(p, arr[j]) ) j--; //피봇보다 크면
				if(i>=j) return j;
				swap(arr, i, j);
			}
			swap(arr, i, j);	
			return j; 		   // a[j]의 피봇이 "영원히" 자리 잡은 곳
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
			Quick quick = new Quick(); //quick 객체 생성
			Integer[] arr = quick.init(10); // 정렬할 배열 생성
			sort(arr, 0, arr.length-1);
			
		}
}
