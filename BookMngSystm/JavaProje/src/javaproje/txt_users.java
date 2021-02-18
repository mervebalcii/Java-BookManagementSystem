/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproje;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author MERVE
 */
public class txt_users {
     public static void main(String[] args) throws SQLException {
     try {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
    } catch (ClassNotFoundException e1) {
       
        e1.printStackTrace();
    }
try {
     Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/BOOKMNG", "MERVE", "1234");
      Statement select = con.createStatement();
      ResultSet result = select.executeQuery
                          ("select * from USERS");         

      System.out.println("Got results:");
      System.out.println(result);
      FileWriter fw = new FileWriter("C:\\Users\\MERVE\\Desktop\\MERVE_BALCI_1821221022\\new_users.txt"); 
      BufferedWriter bw = new BufferedWriter(fw);
     
      while(result.next()) 
      {  
          try{ 
           bw.write(result.getString("USERID"));; 
          bw.write(result.getString("USERNAME"));; 
           bw.write(result.getString("USERPASSW"));; 
           bw.write(result.getString("GENDER"));;   

             bw.newLine();
         
          }  
          catch (Exception e) {  
              System.out.println("Eror writing to a file :"+e);  
          }            
      }  
      bw.close();
      select.close();
      con.close();
    }
    catch( Exception e ) {
      e.printStackTrace();
    }
        
        
     }  
    }

