/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import DB.ConfigDB;
import java.sql.*;


/**
 *
 * @author Duy Thanh
 */
public class Accounts {
    public String username;
    public String password;

    
    public Accounts(String username, String password){
        this.username = username;
        this.password = password;
    }
    public boolean checkUsername(){
        
        try{
            Statement s = ConfigDB.Connection().createStatement();
            String sqlCMD = "Select * from Accounts";
            ResultSet rs = s.executeQuery(sqlCMD);
            
            while(rs.next()){
                if(rs.getString("UserName").equals(username)){
                    s.close();
                    return true;
                }
            }                    
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean checkPassword(){
        try{
            Statement s = ConfigDB.Connection().createStatement();
            String sqlCMD = "Select * from Accounts";
            ResultSet rs = s.executeQuery(sqlCMD);
            
            while(rs.next()){
                if(rs.getString("Password").equals(password)){
                    s.close();
                    return true;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public void saveAccount(){
        int UserID = 0;
        try{
            Statement s = ConfigDB.Connection().createStatement();
            String sqlURL = "Select count(UserID) from Accounts";
            ResultSet rs = s.executeQuery(sqlURL);
            while(rs.next()){
                UserID = rs.getInt(1);
            }
            UserID++;
            
            String sqlURL1 ="insert into Accounts value ("+UserID+","+username+","+password+");";
            s.execute(sqlURL1);
            s.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
