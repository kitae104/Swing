package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerEx {

	public static void main(String[] args) {
		ServerSocket server = null;
		Socket socket = null;
		BufferedReader in = null;
		BufferedWriter out = null;
		Scanner sc = new Scanner(System.in);
		try {
			server = new ServerSocket(9999);
			System.out.println(">> 연결을 기다리고 있습니다....");
			socket = server.accept();
			System.out.println(">> 연결되었습니다.");
			
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			while(true) {
				String inMessage = in.readLine();
				
				if(inMessage.equalsIgnoreCase("bye")) {
					System.out.println("클라이언트가 나갔습니다.");
					break;
				}				
				System.out.println("[클라이언트] : " + inMessage);
				
				System.out.print("보내기>>");
				String outMessage = sc.nextLine();
				out.write(outMessage + "\n");
				out.flush();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				out.close();
				in.close();
				socket.close();
				server.close();
				sc.close();
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}

	}

}







