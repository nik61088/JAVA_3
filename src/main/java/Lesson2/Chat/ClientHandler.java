package Lesson2.Chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private String name;
    private DataInputStream in;
    private DataOutputStream out;
    private Socket socket;
    private Chat chat;

    public ClientHandler(Socket socket, Chat chat) {
        this.socket = socket;
        this.chat = chat;
        try {
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            doAuth();
            readMessage();
        }).start();

    }

    public String getName() {
        return name;
    }

    public void sendMessage(String message){
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void readMessage(){
        while (true){
            try {
                String message = in.readUTF();
                System.out.println(name+": "+message);
                if (message.equals("/end")) {
                    return;
                }
                chat.messageToAll(name + ": "+message);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    private void doAuth() {
        sendMessage("Please enter credentials. Sample [-auth login password]");
        try {
            while (true){
                String mayBeCredentials = in.readUTF();
                if (mayBeCredentials.startsWith("-auth")){
                    String[] credentials = mayBeCredentials.split("\\s");
                    String mayBeNickname = chat.getAuthenticationService().
                            findNicknameLoginAndPassword(credentials[1], credentials[2]);
                    if (mayBeNickname != null){
                        if (!chat.isNickNameOccupied(mayBeNickname)){
                            sendMessage("[INFO] Auth Ok");
                            name = mayBeNickname;
                            chat.messageToAll(String.format("[%s] logged in", name));
                            chat.addingUser(this);
                            return;
                        } else {
                            sendMessage("[INFO] Current user is logged in");
                        }
                    } else {
                        sendMessage("[INFO] Wrong login or password");
                    }
                }
            }
        }catch (Exception e){
            throw new RuntimeException("SWW", e);
        }
    }
}
