package sample;

import java.sql.*;

public class DBConnection {


    //variables
    public Statement statement;
    public Connection connection;
    public ResultSet resultSet;
    public String url = "jdbc:mysql://localhost:3306/toothbrush";
    public String username = "root";
    public String password = "root";



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

    public boolean login(String email, String pass) {

        try {
            //select * from customer where email = 'louliett@gmail.com' and password = 'pas'
            String query = "select * from customer where email = '" + email + "' and password = '" + pass + "' ;";
            resultSet = statement.executeQuery(query);

            if(resultSet.next()) {
                return true;
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return false;

    }

    public void buyRed(int quant) throws SQLException {

        //select quantity from product where idproduct = 0;
        String query = "select quantity from product where idproduct = 0;";
        resultSet = statement.executeQuery(query);

        int q = 0;
        while(resultSet.next()){
            q = resultSet.getInt("quantity");
            q = q - quant;
        }

        System.out.println(q);

        String query2 = "update product set quantity = " + q + " where idproduct = 0 ;";
        statement.executeUpdate(query2);

        System.out.println("I guess just " + q);


    }

    public void buyBlue(int quant) throws SQLException {

        //select quantity from product where idproduct = 0;
        String query = "select quantity from product where idproduct = 1;";
        resultSet = statement.executeQuery(query);

        int q = 0;
        while(resultSet.next()){
            q = resultSet.getInt("quantity");
            q = q - quant;
        }

        String query2 = "update product set quantity = " + q + " where idproduct = 1 ;";
        statement.executeUpdate(query2);
        System.out.println(q);
        System.out.println("I guess just " + q);
    }

    public int displayRed() throws SQLException {

        //select quantity from product where idproduct = 0;
        String query = "select quantity from product where idproduct = 0;";
        resultSet = statement.executeQuery(query);

        if (resultSet.next()) {
            int quantity = resultSet.getInt("quantity");
            return quantity;
        }

        return 0;
    }

    public int displayBlue() throws SQLException {

        //select quantity from product where idproduct = 0;
        String query = "select quantity from product where idproduct = 1;";
        resultSet = statement.executeQuery(query);

        if (resultSet.next()) {
            int quantity = resultSet.getInt("quantity");
            return quantity;
        }
        return 0;
    }


}
