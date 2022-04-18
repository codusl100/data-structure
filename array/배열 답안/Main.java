import java.util.Scanner;

public class Main {
	
	static int ct=0;
	public static void get(int[] arr, int idx) {
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
	public static int[] et(int[] old) {
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
	public static int[] add(int[] arr, int apd) {
		ct+=1;
		
		if(arr.length<ct) {
			arr=et(arr);
		}
		
		arr[ct-1]=apd;
		
		return arr;
		
	}
	public static int[] insert(int[] arr, int pc,int wh) {
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
	public static int[] drop(int[] arr) {
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
	public static int[] pdrop(int[] arr, int wh) {
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
	public static int[] ckresize(int[] arr) {
		
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
	public static void printlen(int[] arr) {
		System.out.println("배열의 길이 : "+arr.length);
		System.out.println("데이터 개수 : "+ct);
		System.out.println("비율 : "+(float)ct/arr.length);
		for(int i=0;i<arr.length; i++) {
			System.out.print(arr[i]);
		}
		System.out.println();
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[0];
		boolean fin;
		int whe;

		int ts,ww;
	
		fin=true;
		while(fin) {
			System.out.println("1. 값가져오기 ");
			System.out.println("2. 맨뒤에 값 넣기 ");
			System.out.println("3. 특정 위치 값 넣기 ");
			System.out.println("4. 맨뒤에 값 빼기 ");
			System.out.println("5. 특정 위치 값 빼기 ");
			System.out.println("6. 배열 길이 데이터 개수 비율 체크 ");
			System.out.println("7. 끝내기 ");
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
				fin=false;
				break;
			default:
				System.out.println("없는메늅니다 다시 입력하세요 ");
				break;
			}
		}

//		값을가져올때 인덱스는 0부터 전체입력값 length-1까지로 가져와야한다
//		특정위치 값넣기할때 위치 인덱스 입력하고 엔터치고 넣을 값을 넣을값을 입력하면된다
//		특정위치에 값을 넣고 값을 뺄때 인덱스는 0부터 length-1 범위로써의 인덱스다
//		ct는 배열에 들어간 숫자값을 가진 변수이고 위에 주석 설명에 length는 ct값을 말하는거다(총 배열길이의 length를 말하는게아님)
//		특정위치에 값을 넣을때는 원래 배열에 들어있는값중 사이에인덱스만 적용되고 앞에 아무값이 없는데 넣으려고하면 배열 범위를 넘었다고 알린다 
		
//		2번으로 값을 넣고 다른동작들을 수행하는것을 추천한다(값이있어야 사이에 넣기도 되고 삭제도되고 조회도되니까) 
	}

}


