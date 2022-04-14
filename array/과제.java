import java.util.Scanner;
public class main {
	static Scanner sc= new Scanner(System.in);
	static int count=0; //배열에 항목 담고 있는지 여부
	public static int[] MakeArray(int n) //*배열 생성 메소드
	{
		int[] arr=null; //데이터도 없는 배열 생성
		try{
			arr= new int[n]; //크기가 n인 1차원 배열 생성
		}
		catch(Exception e) //값이 없을 경우 예외 처리
		{
			System.out.println("값이 없을 경우의 에러 발생");
			System.out.println("값이 0(null)이 아니어야 함");
			System.out.println("0보다 큰 수를 입력해주세요");
		}
		return arr;
	}
	public static void findarr(int[] arr, int k)//*배열 값 가져오기 메소드
	{	
		System.out.println("배열 사이즈: "+arr.length);
		System.out.println("배열 데이터 개수: "+count);
		System.out.println(arr[k]); //배열의 k번째 항 값 출력
	}
	public static int[] printArray(int[] arr) //*배열 출력 메소드
	{	
		System.out.print("배열 출력: ");
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println("");
		return arr;
	}
	public static int[] fininsert(int[] arr, int x) //배열 값 끝에 추가 메소드
	{
		try{arr[count]=x;
		count++;} //값을 담고 있는 배열 항 카운팅
		catch(Exception e) {
			System.out.println("Overflow 발생");
			//예외 처리
			fininsertex(arr, x);
		}
		return arr;
	}
	public static int[] fininsertex(int[] arr, int x) //배열 값 끝 추가 overflow 처리 메소드
	{
			int[] newarr= new int[arr.length*2]; //arr배열 크기의 2배인 새로운 newarr 배열 생성
			for(int i=0;i<arr.length;i++) {
				newarr[i]=arr[i]; //arr배열을 newarr배열에 복사
			}
			newarr[count]=x; //newarr 배열 끝 항에 새로운 x값 추가
			count++; //배열 항이 추가되어 count 세어짐
			for(int i=0;i<newarr.length;i++) {
				System.out.print(newarr[i]+" ");
				}
			return newarr;
	
	}
	public static void midinsert(int[] arr, int index, int x) //배열 중간 삽입 메소드
	{	
		try{
			for(int i=count;i>index;i--) 
			{ //차있는 인덱스에서 넣으려고 하는 인덱스 전 항까지 값들을 이동한다
				arr[i]=arr[i-1];
			}
			arr[index]=x;
			count++; //삽입했으니 count++처리
		}
		catch(Exception e) {
			System.out.println("Overflow 발생");
			midinsertex(arr, index, x);
		}
	}
	public static int[] midinsertex(int[] arr, int index, int x) { //배열 중간 삽입 예외 처리 메소드
			//예외처리
			int[] newarr2= new int[arr.length*2]; //arr배열 크기의 2배인 새로운 newarr2 배열 생성
			for(int i=0;i<arr.length;i++) {
				newarr2[i]=arr[i]; //기존 배열 값을 새로운 배열 값에 복사
			}
			for(int i=count;i>index;i--) { //차있는 인덱스에서 넣으려고 하는 인덱스 전 항까지 값들을 이동한다
				newarr2[i]=newarr2[i-1];
			}
			newarr2[index]=x;
			count++; //삽입했으니 count++처리
			for(int i=0;i<newarr2.length;i++) {
			System.out.print(newarr2[i]+" ");
			}
			return newarr2;
	}
	public static void findelete(int[] arr){ //*배열 끝 삭제
		int[] newarr3=new int[arr.length/2];
		arr[count-1]=0; //마지막 값 null 처리
		count--;
		//예외처리
		if((double)(count/arr.length)<=0.25) { //배열 크기 중 데이터 값 갖고 있는 항의 비율이 25% 이하라면
			for(int i=0;i<newarr3.length;i++)
				newarr3[i]=arr[i]; //기존 배열 값을 새로운 배열에 복사
		}//배열에서 필요한 기능-행렬 크기 변화	
	}
	public static void middelete(int[] arr, int index) //*배열 중간 삭제
	{	
		int[] newarr4= new int[arr.length/2];
		arr[index]=0; //null을 의미
		for(int i=index;i<count-1;i++) { //비어진 index항부터 count까지-> i<count로 하면 boundary 오류
			arr[i]=arr[i+1];
		}
		count--;
		//예외처리
		if((double)(count/arr.length)<=0.25)
		{
			for(int i=0;i<newarr4.length;i++) {
				newarr4[i]=arr[i]; //기존 배열 값을 새로운 배열에 복사
			}
		} //배열에서 필요한 기능-행렬 크기 변화
	}
	public static void main(String[] args) {
		int arr[]=new int[5]; //arr라는 배열 선언
		fininsert(arr, 0); //arr배열에 숫자 0 추가
		fininsert(arr, 4); //arr배열에 숫자 4 추가
		fininsert(arr, 3); //arr배열에 숫자 3 추가
		fininsert(arr, 5); //arr배열에 숫자 5 추가
		fininsert(arr, 0); //arr배열에 숫자 0 추가
		//배열의 응용 다항식 - A(x)의 상수 계수들을 배열에 추가
		printArray(arr); //출력
		

		int arr2[]=new int[5]; //arr2라는 배열 선언
		count=0; //arr2 배열 생성 후 담고 있는 항 (count) 0으로 초기화
		fininsert(arr2, 3); //arr2배열에 숫자 3 추가
		fininsert(arr2, 1); //arr2배열에 숫자 1 추가
		fininsert(arr2, 0); //arr2배열에 숫자 0 추가
		fininsert(arr2, 2); //arr2배열에 숫자 2 추가
		fininsert(arr2, 1); //arr2배열에 숫자 1 추가
		printArray(arr2);
		int ARRAY[] =new int[5]; //두 다항식을 더했을 때 상수 계수를 담을 배열 ARRAY 생성
		for(int i=0;i<ARRAY.length;i++)
		{
			ARRAY[i]=arr[i]+arr2[i]; // 두 다항식의 합
		}
		System.out.print("두 다항식의 합: ");
		for(int i=0;i<ARRAY.length;i++)
		{
			System.out.print(ARRAY[i]+" ");
		}
		
	}
}
