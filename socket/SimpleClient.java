package training3;

import java.io.*; 
import java.net.*;

public class SimpleClient{
    public static void main(String[] args){
    	//IOStream을 불러옵니다.
        OutputStream os;
        BufferedReader br_out;
        FileOutputStream fos;
        PrintWriter pw = null;

        try{
            String data = null;
            
            //localhost와 8404포트를 가지는 소켓 객체를 생성한다.
            Socket s1 = new Socket("127.0.0.1", 8404);
            
            //input.txt의 문장들을 읽어온 후 Client에서 Server로 데이터를 전달한다.
            os = s1.getOutputStream();
            br_out=new BufferedReader(new FileReader("input.txt"));
            fos = new FileOutputStream("input.txt");
            
            //데이터(받아온 정보)를 개행문자 단위로 끊어 행별로 출력한다.
            pw = new PrintWriter("input.txt");
            while((data=br_out.readLine())!=null){
                System.out.println(data);
                pw.println(data);
            }
            System.out.println("File Sented...");
            pw.close();
            s1.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
