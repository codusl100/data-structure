import java.util.Scanner;

public class Array {

	private int ct=0;
	private int[] arr = new int[0];
	
	public int getct() {
		return ct;
	}
	public int[] getarr() {
		return arr;
	}
	public void makearray() {
		Scanner sc = new Scanner(System.in);
		int whe,ts,ww;
		boolean fin;
		fin=true;
		
		while(fin) {
			System.out.println("1. 값가져오기 ");
			System.out.println("2. 맨뒤에 값 넣기 ");
			System.out.println("3. 특정 위치 값 넣기 ");
			System.out.println("4. 맨뒤에 값 빼기 ");
			System.out.println("5. 특정 위치 값 빼기 ");
			System.out.println("6. 배열 길이 데이터 개수 비율 체크 ");
			System.out.println("7. 배열 출력하기 ");
			System.out.println("8. 끝내기 ");
			whe=sc.nextInt();
			switch(whe) {
			case 1:
				System.out.println("몇번째 인덱스 값가져올까요? ");
				ts=sc.nextInt();
				get(arr,ts); 
				break;
			case 2:
				System.out.println("무슨 값을 넣을래요? ");
				ts=sc.nextInt();
				arr=add(arr,ts);
				for(int i=0;i<arr.length;i++) {
					System.out.print(arr[i]+" ");
				}
				System.out.println();
				break;
			case 3:
				System.out.println("어디에 무슨 값을 넣을래요?(위치,값 순) ");
				ww=sc.nextInt();
				ts=sc.nextInt();
				if(ww>=arr.length) {
					System.out.println("배열 범위를 넘었습니다");
					break;
				}
				arr=insert(arr,ts,ww);
				for(int i=0;i<arr.length;i++) {
					System.out.print(arr[i]+" ");
				}
				System.out.println();
				break;
			case 4:
				System.out.println("맨뒤값 뺄게요 ");
				arr=drop(arr);
				for(int i=0;i<arr.length;i++) {
					System.out.print(arr[i]+" ");
				}
				System.out.println();
				break;
			case 5:
				System.out.println("어디에 값을 뺄래요? ");
				ww=sc.nextInt();
				arr=pdrop(arr,ww);
				for(int i=0;i<arr.length;i++) {
					System.out.print(arr[i]+" ");
				}
				System.out.println();
				break;
			case 6:
				System.out.println("출력해볼게요");
				printlen(arr);
				break;
			case 7:
				printarr();
				break;
			case 8:
				fin=false;
				break;
			default:
				System.out.println("없는메늅니다 다시 입력하세요 ");
				break;
			}
		}
	}
	
	public void get(int[] arr, int idx) {
		if (ct>0) {
			if (arr.length>idx) {
				System.out.println(arr[idx]);
			}
			else {
				System.out.println("해당인덱스는 배열의 크기를 넘어섭니다 ");
				
			}
		}
		else {
			System.out.println("아무런 값이 없습니다");
		}
		
	}
	public int[] et(int[] old) {
		int lt;
		if(old.length==0) {
			lt=1;
			int newa[]=new int[lt*2];
			
			return newa;
		}
		else {
			
			lt=old.length;
			int newa[]=new int[lt*2];
			for(int i=0;i<old.length;i++) {
				newa[i]=old[i];
			}
			
			return newa;
		}

	}
	public int[] add(int[] arr, int apd) {
		ct+=1;
		
		if(arr.length<ct) {
			arr=et(arr);
		}
		
		arr[ct-1]=apd;
		
		return arr;
		
	}
	public int[] insert(int[] arr, int pc,int wh) {
		ct+=1;
		int[] newa;
		if(arr.length<ct) {
			
			newa=et(arr);
			for(int i=ct-1;i>wh;i--) {
				newa[i]=arr[i-1];
			}
			newa[wh]=pc;

			return newa;
		}
		else {
			for(int i=ct-1;i>wh;i--) {
				arr[i]=arr[i-1];
			}
			arr[wh]=pc;
			return arr;
			
		}
		
	}
	public int[] drop(int[] arr) {
		ct-=1;
		if (ct<0) {
			System.out.println("뺄게없습니다 ");
			ct+=1;
		}
		else {
			arr[ct]=0;
		}
		
		arr=ckresize(arr);
		return arr;
	}
	public int[] pdrop(int[] arr, int wh) {
		ct-=1;
		if(ct<0) {
			System.out.println("뺄게없습니다");
			ct+=1;
		}
		else if(ct<wh){
			System.out.println("그만큼 값이 없습니다 ");
			ct+=1;
		}
		else {
			for(int i=wh;i<ct;i++) {
				arr[i]=arr[i+1];
			}
			arr[ct]=0;
		}
		arr=ckresize(arr);
		return arr;
		
	}
	public int[] ckresize(int[] arr) {
		
		int[] newa=new int[arr.length/2];
		if((float)ct/arr.length<=0.25) {
			for(int i=0;i<newa.length;i++) {
				newa[i]=arr[i];
			}
			return newa;
		}
		else {
			return arr;
		}
	}
	public void printlen(int[] arr) {
		System.out.println("배열의 길이 : "+arr.length);
		System.out.println("데이터 개수 : "+ct);
		System.out.println("비율 : "+(float)ct/arr.length);
		for(int i=0;i<arr.length; i++) {
			System.out.print(arr[i]);
		}
		System.out.println();
		
	}
	
	public void printarr() {
		for(int i=0; i<ct; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		
	}
}
