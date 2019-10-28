/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author haticeozbakir
 */
import Entity.groups;
import Entity.users;
import Utility.ConnectionManager;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class usersDAO {
  private users us=null;
  private ArrayList<users> uslist=null;
    public users getUsers(Long id){
        Connection con =ConnectionManager.getConnection();
        try{
            PreparedStatement st=con.prepareStatement("select *from users where userID=?");
            st.setLong(1, id);
            ResultSet rs =st.executeQuery();
            rs.next();
            this.us =new users(rs.getLong("userID"),rs.getString("kullaniciAdi"),rs.getString("sifre"));
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        return this.us;
    }
      public ArrayList<users> list(){
    this.uslist=new ArrayList();
    Connection con=ConnectionManager.getConnection();
    try{
        PreparedStatement pst=con.prepareStatement("select *from users order by userID "); 
        ResultSet rs=pst.executeQuery();
        while(rs.next()){
        users u=new users();
        u.setUserID(rs.getLong("userID"));
        u.setKullaniciAdi(rs.getString("kullaniciAdi"));
        u.setSifre(rs.getString("sifre"));
       
        this.uslist.add(u);
        }
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    return this.uslist;
    }
   
       public void delete(users u){
        Connection con =ConnectionManager.getConnection();
        try{
            PreparedStatement pst =con.prepareStatement("delete from users where userID=?");
            pst.setLong(1, u.getUserID());
            pst.executeUpdate();
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());}
    }
        public void update(users u){
        Connection con =ConnectionManager.getConnection();
        try{
            String update="update users set sifre=?,kullaniciAdi=? where userID=?";
            PreparedStatement pst=con.prepareStatement(update);
            pst.setString(1, u.getSifre());
            pst.setString(2, u.getKullaniciAdi());
            pst.setLong(3, u.getUserID());
            pst.executeUpdate();
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        }
        public void create(users u){
              Connection con =ConnectionManager.getConnection();
        try{
            PreparedStatement pst=con.prepareStatement("insert into users(kullaniciAdi,sifre) values (?,?)",Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, u.getKullaniciAdi());
            pst.setString(2, u.getSifre());
            pst.executeUpdate();
            Long userID=null;
            ResultSet gk=pst.getGeneratedKeys();
            if(gk.next()){
             userID=gk.getLong(1);
            }
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        
      
        }

 
}
    
    