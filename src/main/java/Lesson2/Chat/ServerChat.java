package Lesson2.Chat;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class ServerChat implements Chat {
    private ServerSocket serverSocket;
    private Set<ClientHandler> clients;
    private Authent authenticationService;


    public ServerChat(){
        start();
    }

    private void start(){
        try {
            serverSocket = new ServerSocket (8080);
            clients = new HashSet<>();
            authenticationService = new Authent();

        while (true){

                System.out.println("Сервер ждет подключения");
                Socket socket = serverSocket.accept();
                ClientHandler client = new ClientHandler(socket, this);
                System.out.println("Клиент залогинился");
            }
            }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void messageToAll(String message){
        for (ClientHandler client: clients) {
            client.sendMessage(message);
        }
    }

    public void addingUser(ClientHandler client){
        clients.add(client);
    }
    public void removeUser(ClientHandler client){
        clients.remove(client);
    }

    public boolean isNickNameOccupied(String mayBeNickname) {
        for (ClientHandler client: clients) {
            if (client.getName().equals(mayBeNickname)){
                return true;
            }
        }
        return false;
    }

    public Authent getAuthenticationService() {
        return authenticationService;
    }
}
