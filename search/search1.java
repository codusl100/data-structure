import java.util.Random;
import java.util.Scanner;
public class search1 {
	
	public static int search(int arr[], int len, int target) {
		 	int i;
		    for(i=0; i<len; i++) {
		    	if(arr[i]==target)
		    		return i;
		    };
		    return -1;
		    }
	public static int[] resize(int arr[], int len) { 
		int[] newarr= new int[len];
		for(int i=0; i<arr.length;i++) {
			newarr[i]= arr[i];
		}
		return newarr;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random(); // 랜덤 객체 생성 
		
		int random1 = rand.nextInt(100)+1;
		int[] arr = new int [random1]; 
		System.out.println("배열 크기: "+random1);
		
		int random2 = rand.nextInt(100)+1;
		System.out.println("삽입할 데이터 개수: "+random2);
		
		if(random1>=random2) {
		for(int i=0; i<random2; i++) {
			arr[i]=rand.nextInt(100)+1;
			}
		}
		else {
			arr = resize(arr, random2);
			for(int i=0;i<random2;i++) {
				arr[i]=rand.nextInt(100)+1;
			}
		}
		System.out.print("배열 삽입 결과 : [");
		for(int k=0; k<arr.length;k++) {
			System.out.print(arr[k]+" ");
		}
		System.out.print("]");
		System.out.println("\n");
		System.out.print("탐색할 값을 입력하시오: ");
		int num = sc.nextInt();
		
		int ans = search(arr, arr.length, num);
		if(ans==-1) System.out.println("탐색을 실패했습니다.");
		else	System.out.println("탐색을 성공했습니다.");
	}

}
