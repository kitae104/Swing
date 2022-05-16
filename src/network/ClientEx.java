package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ClientEx {

	public static void main(String[] args) {
		
		Socket socket = null;
		BufferedReader in = null;
		BufferedWriter out = null;
		Scanner sc = new Scanner(System.in);
		try {			
			socket = new Socket("127.0.0.1", 9999);	
			System.out.println("서버 연결 완료!");
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			while(true) {
				System.out.print("보내기>>");
				String outMessage = sc.nextLine();
				
				if(outMessage.equalsIgnoreCase("bye")) {
					out.write(outMessage + "\n");
					out.flush();
					break;
				}
				
				out.write(outMessage + "\n");
				out.flush();
				
				String inMessage = in.readLine();
				System.out.println("[서버] : " + inMessage);			
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
				in.close();
				socket.close();				
				sc.close();
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}

	}

}







