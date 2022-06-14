public void print() {
		System.out.print("random number table : \n");
		for (int i=0; i<a.length;i++){
			System.out.print(a[i]==null?null+"-->": "{ key: "+a[i].getKey()+" } -->");
			System.out.print(a[i]==null? null+" ": " { data: "+a[i].getData()+" } ");
			System.out.println("\n");
		}
		System.out.println("\n");
	}
	
