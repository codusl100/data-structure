package training3;

import java.io.*; 
import java.net.*;

public class SimpleServer{
    public static void main(String[] args){
    	//IOStream을 불러옵니다
        BufferedReader br;
        FileInputStream fin;
        PrintWriter pw = null;

        //Socket & Server Socket 선언
        ServerSocket serverSocket;
        Socket s1 = null;

        String data;

        try{
        	//전송받은 파일 데이터를 저장할 out.text 파일을 생성한다
        	FileWriter writer = new FileWriter("out.txt");

        	//포트번호 8404의 서버 소켓을 생성하고 이를 콘솔에 표시한다.
            serverSocket = new ServerSocket(8404);
            System.out.println("Server ON...");

            //연결을 수락한 후 소켓을 생성하고 클라이언트로부터 정보를 받아온다.
            s1=serverSocket.accept(); //연결 수락 + 소켓 생성
            fin = new FileInputStream("input.txt"); //정보 받아옴
            br = new BufferedReader(new InputStreamReader(fin));
            
            //input 파일의 데이터(받아온 정보)를 개행문자 단위로 끊어 행별로 출력한다.
            pw = new PrintWriter("input.txt");
            while((data=br.readLine())!=null){
                System.out.println(data);
                pw.println(data);
            }
            pw.close();
            s1.close();
        }
        catch(IOException ie){
            ie.printStackTrace();
        }
    }
}
