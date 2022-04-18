import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int maxct;
		
		Array ar1= new Array();
		Array ar2= new Array();
		int[] arr1,arr2,rearr;
		ar1.makearray();
		ar2.makearray();
		
//		ar1.printarr();
//		ar2.printarr();
		
		arr1=ar1.getarr();
		arr2=ar2.getarr();
		
		if(ar1.getct()>ar2.getct()) {
			maxct=ar1.getct();
		}
		else {
			maxct=ar2.getct();
		}
		
		rearr=new int[maxct];
		
		for(int i=0; i<maxct; i++) {
			rearr[i]=arr1[i]+arr2[i];
//			System.out.println(arr1[i]+" "+arr2[i]);
		}
		
		for(int i=0;i<maxct;i++) {
			if(rearr[i]==0) {
				continue;
			}
			else {
				if ((maxct-1-i)==0) {
					System.out.print(rearr[i]);
				}
				else {
					System.out.print(rearr[i]+"x^"+(maxct-1-i)+" + ");
				}
				
			}
		}
		System.out.println();
		
//		앞에 배열을 클래스로 변경하여 문제를 해결했습니다 
//		2번으로 배열의 계수를 입력합니다
//		계수가 0인 부분은 0으로 입력을 해주어야합니다
//		배열1 2 둘다 빈곳은 0으로 채워서 길이를 맞춰줘야합니다
//		각배열을 다입력하면 8번을 눌러 배열을 확정 냅니다
//		8번으로 첫번째 배열을 끝내면 바로이어서 두번째 배열을 입력하게 합니다 
//		배열을 입력하면서 7번을 통해 배열의 계수를 확인할 수 있습니다
//		두번째 배열을 입력 다받고 8번을 누르게 된다면 바로 합이된 결과가 출력됩니다.
	
	
	}

}


