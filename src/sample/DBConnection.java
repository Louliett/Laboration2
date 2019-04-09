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
    private String url = "jdbc:mysql://ecarte.mysql.database.azure.com:3306/drive?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String username = "masm@ecarte";
    private String password = "Password1";


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

    public void getName() {
        try {
            String query = "select * from person";
            resultSet = statement.executeQuery(query);
            System.out.println("Records from database: ");
            while(resultSet.next()) {
                String name = resultSet.getString("name");
                System.out.println("Name: " + name);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

    }

}
