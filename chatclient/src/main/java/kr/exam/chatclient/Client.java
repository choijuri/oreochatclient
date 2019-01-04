package kr.exam.chatclient;

import java.io.*;
import java.net.Socket;

public class Client {
    private String ip;
    private int port;

    public Client(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public void run(){
        Socket socket = null;
        ChatUser chatUser = null;
        BufferedReader br = null;
        try{
            br = new BufferedReader(new InputStreamReader(System.in));
            socket = new Socket(ip, port); // 서버에 접속
            chatUser = new ChatUser(socket);

            System.out.println("닉네임을 입력하세요.");
            String nickName = br.readLine();
            chatUser.setNickname(nickName);
            
            // 방 메뉴들을 예쁘게 정리했습니다.

            System.out.println("명령어를 입력 하세요.");
            System.out.println("1. /create + 방제목");
            System.out.println("2. /join");
            System.out.println("3. /roomlist");
            System.out.println("4. /quit");
            Thread t = new Thread(new ClientHandler(chatUser));
            t.start();


            while(true){
                String line = br.readLine();
                chatUser.write(line);
            }
        }catch (Exception ex){
            // 접속이 끊어지면 Exception;
            System.out.println("연결이 끊어졌습니다.");
        }finally {
            chatUser.close();
        }
    }
}
