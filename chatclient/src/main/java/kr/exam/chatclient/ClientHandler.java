package kr.exam.chatclient;

public class ClientHandler implements Runnable {


    private ChatUser chatUser;
    public ClientHandler(ChatUser chatUser){
        this.chatUser = chatUser;
    }

    public void run(){
        while(true){
            String line = chatUser.read();// 서버가 보내주는 정보를 읽어들인다.
            System.out.println(line);
        }
    }
}
