package Lesson2.Chat;

public interface Chat {
    public void messageToAll(String message);
    public void addingUser(ClientHandler client);
    public void removeUser(ClientHandler client);
    public boolean isNickNameOccupied(String mayBeNickname);
    public Authent getAuthenticationService();

}
