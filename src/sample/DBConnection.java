package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {


    //variables
    private Statement statement;
    private Connection connection;
    private ResultSet resultSet;
    private String url = "jdbc:mysql://localhost:3306/toothbrush";
    private String username = "root";
    private String password = "root";


    public DBConnection() {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            System.out.println("Database connected");

        }catch(Exception e) {
            System.out.println("SQL " + e);
        }
    }

    public void getEmail() {
        try {
            String query = "select * from customer";
            resultSet = statement.executeQuery(query);
            System.out.println("Records from database: ");
            while(resultSet.next()) {
                String name = resultSet.getString("email");
                System.out.println("email: " + name);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

    }

}
