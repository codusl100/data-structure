CircularDeque<Integer> j = new CircularDeque<>();
		System.out.print("N과 K를 입력하시오: ");
		int N = sc.nextInt(); //사람 수 N명 입력
		int K = sc.nextInt(); //제거할 순서 K 입력
		String ans = ""; //요세푸스 순열을 담을 문자열
		for(int i=1;i<N+1;i++) { //1~N명의 사람이 원을 이루며 앉아있으므로 구간은 1부터 N까지 설정
			j.add_rear(i); //j 데크에 1~ N까지 저장한다
		}
		
		while(!j.isEmpty()) { //j 데크가 비어있지 않을 동안
			for(int i=1;i<K;i++) { //제거할 k항 앞자리 사람까지
				j.add_rear(j.remove_front()); //항 제거한 후 뒷자리에 넣는다.
				} //j 데크의 front값은 제거할 k번째 항
			ans+=j.remove_front(); //k번째 항 제거 후 문자열에 추가한다.
			if(!j.isEmpty()) //아무도 남지 않을 때까지 ans에 추가하고, empty 상태가 아니라면 , (comma)도 추가한다.
				ans+=", "; //비어 있을 경우엔 , (comma) 추가 안함
		}
		System.out.print("<");
		System.out.print(ans); //요세푸스 순열 출력!
		System.out.print(">");
