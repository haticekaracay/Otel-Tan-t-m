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
import Utility.ConnectionManager;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


public class groupsDAO {
  private groups gr=null;
  private ArrayList<groups> grlist=null;
  

    public ArrayList<groups> list(){
    this.grlist=new ArrayList();
    Connection con=ConnectionManager.getConnection();
    try{
        PreparedStatement st=con.prepareStatement("select *from groups order by gID desc");
        ResultSet rs=st.executeQuery();
        while(rs.next()){
        groups g=new groups();
        g.setGrID(rs.getLong("gID"));
        g.setKullaniciAdi(rs.getString("kullaniciAdi"));
        g.setSifre(rs.getString("sifre"));
        grlist.add(g);
        }
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    return this.grlist;
    }
      
       public void delete(groups g){
        Connection con =ConnectionManager.getConnection();
        try{
            String delete="delete from groups where gID=?";
            PreparedStatement ps=con.prepareStatement(delete);
            ps.setLong(1, g.getGrID());
            ps.executeUpdate();
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());}
    }
        public void update(groups g){
        Connection con =ConnectionManager.getConnection();
        try{
            String update="update groups set sifre=?, kullaniciAdi=? where gID=?";
            PreparedStatement pst =con.prepareStatement(update);
            pst.setString(1, g.getSifre());
            pst.setString(2, g.getKullaniciAdi());
            pst.setLong(3, g.getGrID());
            pst.executeUpdate();
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        }
        public void create(groups g){
              Connection con =ConnectionManager.getConnection();
        try{
           PreparedStatement pst=con.prepareStatement("insert into groups(kullaniciAdi,sifre) values (?,?)",Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, g.getKullaniciAdi());
            pst.setString(2, g.getSifre());
            pst.executeUpdate();
            Long gID=null;
            ResultSet gk=pst.getGeneratedKeys();
            if(gk.next()){
             gID=gk.getLong(1);
            }
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        
      
        }

  public groups getGroups(Long id){
        Connection con =ConnectionManager.getConnection();
        try{
            PreparedStatement pst =con.prepareStatement("select *from groups where gID=?");
            pst.setLong(1, id);
            ResultSet rs =pst.executeQuery();
            rs.next();
            this.gr =new groups(rs.getLong("gID"),rs.getString("kullaniciAdi"),rs.getString("sifre"),rs.getLong("userID"));
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        return this.gr;
    }
 
}
    
    