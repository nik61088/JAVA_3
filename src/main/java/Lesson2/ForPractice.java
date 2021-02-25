package Lesson2;

import java.sql.*;

public class ForPractice { // ДЛЯ ПРАКТИКИ
    public static void main(String[] args) throws Exception {



    }

    private static void addToBase() throws ClassNotFoundException, SQLException {
        Connection connection = getConnection();
        String req = "insert into Entries (login, password, nickname) values (?, ?, ?)";
        Long start = System.currentTimeMillis();
        try(PreparedStatement preparedStatement = connection.prepareStatement(req)){
            connection.setAutoCommit(false);
            for (int i = 0; i < 10; i++){
                preparedStatement.setString(1, "l4");
                preparedStatement.setString(2, "p4");
                preparedStatement.setString(3, "nickname4");
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            connection.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        Long finish = System.currentTimeMillis();
        System.out.println("Times is: "+(finish-start));
    }

    private static void statementVsPC() throws Exception {
        String name = "l1";
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from Entries where Login = '" +name+" ' ");
        print(resultSet);

        String injectedName = "A' or 1=1;";
        ResultSet injectedResultSet = statement.executeQuery("select * from Entries where Login = '" +injectedName+" ' '");
        print(injectedResultSet);

        String preparedStatementSQL = "select * from Entries where NickName = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(preparedStatementSQL);
        preparedStatement.setString(1, injectedName);
        ResultSet injectedResulSetPS =preparedStatement.executeQuery();
        print(injectedResulSetPS);

        resultSet.close();
        statement.close();
        connection.close();
    }

    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        Connection connection = DriverManager.getConnection("jdbc:Sqlite:EntriesBase.db");
        return connection;
    }

    private static void print(ResultSet resultSet) throws Exception {
        while (resultSet.next()){
            System.out.print(resultSet.getLong("UserID")+" ");
            System.out.print(resultSet.getString("Login")+" ");
            System.out.print(resultSet.getString("Password")+" ");
            System.out.print(resultSet.getString("NickName")+" ");
        }
    }
}
