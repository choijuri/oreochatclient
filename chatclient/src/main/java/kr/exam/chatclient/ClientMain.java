package kr.exam.chatclient;

public class ClientMain {
    public static void main(String[] args){
        Client client = new Client("127.0.0.1", 9000);
        client.run();
    }
}
