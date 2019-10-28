package Utility;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionManager {
    
    
    private static String sglurl="jdbc:mysql://localhost:3307/tanitimotel?zeroDateTimeBehavior=convertToNull";
    private static String driverName="com.mysql.jdbc.Driver";
    private static String username="özbakır";
    private static String password="CRAZY1905";
    public static Connection con;
    
    public static Connection getConnection(){
    
        try{
            
            Class.forName(driverName).newInstance();
            System.out.println("baglanti basarili");
            con=DriverManager.getConnection(sglurl,username,password);
        }
        catch(SQLException e){
            
            System.out.println("VeritabanÄ±na baÄŸlantÄ± kurulamadÄ±");
          }
        
        catch(ClassNotFoundException | InstantiationException |  IllegalAccessException ex){
            
            System.out.println("Sunucu bulunamadÄ±"); 
        }
        
    return con;
    }   
    
 public void listele(){
       
       try{
           Statement st=con.createStatement();
           ResultSet rs=st.executeQuery("select*from users");
           while(rs.next()){
              
               System.out.println("userID =  " +  rs.getInt(1));
           }
       }catch(SQLException e){
           
           System.out.println("Utilitiy.ConnectionManager.listele()");
       }
    
    }
    
    
    public static void main(String args[]){
    ConnectionManager cm=new ConnectionManager();
    cm.getConnection();
    cm.listele();
    
    }
}