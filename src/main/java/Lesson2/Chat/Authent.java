package Lesson2.Chat;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.Set;

public class Authent {
    private Set<CredentialsEntry> entries;

    public Authent() {
        entries = Set.of(
                new CredentialsEntry("l1", "p1","nickname1"),
                new CredentialsEntry("l2", "p2","nickname2"),
                new CredentialsEntry("l3", "p3","nickname3")
        );
    }

    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        Connection connection = DriverManager.getConnection("jdbc:Sqlite:EntriesBase.db");
        return connection;
    }

    public String findNicknameLoginAndPassword(String login, String password) {
        Connection connection;
        Statement statement;
        ResultSet resultSet = null;

            try {
                connection = getConnection();
                statement = connection.createStatement();
                resultSet = statement.executeQuery("select * from Entries");
                while(resultSet.next()) {
                    if (resultSet.getString("Login").equals(login) && resultSet.getString("Password").equals(password)) {
                        return resultSet.getString("Nickname");
                    }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }


//        for (CredentialsEntry entry: entries) {
//            if (entry.getLogin().equals(login) && entry.getPassword().equals(password)){
//                return entry.getNickname();
//            }
//        }
            return null;

    }

    public static class CredentialsEntry{
        private String login;
        private String password;
        private String nickname;

        public CredentialsEntry(String login, String password, String nickname) {
            this.login = login;
            this.password = password;
            this.nickname = nickname;
        }

        public String getLogin() {
            return login;
        }

        public String getPassword() {
            return password;
        }

        public String getNickname() {
            return nickname;
        }
    }
}
