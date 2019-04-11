package sample;

import org.junit.Assert;
import org.junit.Test;

import java.sql.*;

import static org.junit.Assert.*;

public class DBConnectionTest {




    @Test
    public void login() {
        try {

            Boolean actual;
            Boolean expected = true;

            String email = "louliett@gmail.com";
            String pass = "pas";

            DBConnection dbConnection = new DBConnection();


            actual = dbConnection.login(email,pass);

            Assert.assertEquals(expected,actual);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void displayRed() throws SQLException {

        int actual;

        int expected = 12;

        DBConnection dbConnection = new DBConnection();
        actual = dbConnection.displayRed();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void displayBlue() throws SQLException {

        int actual;

        int expected = 12;

        DBConnection dbConnection = new DBConnection();
        actual = dbConnection.displayBlue();

        Assert.assertEquals(expected,actual);
    }
}