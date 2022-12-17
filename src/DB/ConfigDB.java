/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Duy Thanh
 */
public class ConfigDB {

       
        public static Connection Connection() throws ClassNotFoundException, SQLException{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String URL = "jdbc:sqlserver://localhost:1433;databasename=ChatBox;user=sa;password=1234;encrypt=true;trustServerCertificate=true;";
        //Thực hiện kết nối
        Connection connection = DriverManager.getConnection(URL);       
   
        return connection;
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        Statement statement = Connection().createStatement();
//        statement.execute("Insert into Accounts values('01','Thanh','1234')");
//        Connection().close();
    }
}
