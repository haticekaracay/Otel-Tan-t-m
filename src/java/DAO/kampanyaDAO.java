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
import Entity.kampanya;
import Entity.otel;
import Utility.ConnectionManager;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


public class kampanyaDAO {
   private kampanya kam=null;
   private ArrayList<kampanya> kamlist=null;
   private otelDAO otlDao;

    public otelDAO getOtlDao() {
        if(this.otlDao==null)
            this.otlDao=new otelDAO();
        return otlDao;
    }
   

  

   public kampanya getKam(Long id){
        Connection con =ConnectionManager.getConnection();
        try{
            PreparedStatement pst =con.prepareStatement("select *from kampanya where kamID=?");
            pst.setLong(1, id);
            ResultSet rs =pst.executeQuery();
            rs.next();
            this.kam=new kampanya(rs.getLong("kamID"),rs.getString("kamAdi"),rs.getString("kamBilgi"),rs.getString("kamBaslangic"),rs.getString("kamBitis"));
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        return this.kam;
    }
    
   
   
   public ArrayList<kampanya>list(){
    this.kamlist=new ArrayList<>(); 
    
     Connection con =ConnectionManager.getConnection();
        try{
            PreparedStatement pst =con.prepareStatement("select * from kampanya order by kamID desc");
            ResultSet rs =pst.executeQuery("select * from kampanya");
           while(rs.next()) {
               kampanya k=new kampanya();
               k.setKamID(rs.getLong("kamID"));
               k.setKamAdi(rs.getString("kamAdi"));
               k.setKamBilgi(rs.getString("kamBilgi"));
               k.setKamBaslangic(rs.getString("kamBaslangic"));
               k.setKamBitis(rs.getString("kamBitis"));
               k.setOtelkampanya(this.getOtlDao().getOtelKampanya(k.getKamID()));
              
               this.kamlist.add(k);     
           }
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
     return kamlist;
    }
      ArrayList<kampanya> getOtelKampanya(Long otelID) {
 ArrayList<kampanya> otelKampanya=new ArrayList<>();
         Connection con=ConnectionManager.getConnection();
          try{
        PreparedStatement st=con.prepareStatement("select *from otelkampanya where otelID=?");
        st.setLong(1, otelID);
        ResultSet rs=st.executeQuery();
        while(rs.next()){
           otelKampanya.add(this.find(rs.getLong("kamID")));
           
        } 
       
       }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
       return otelKampanya;
    }
    
      
       public void delete(kampanya k){
        Connection con =ConnectionManager.getConnection();
        try{
            PreparedStatement pst=con.prepareStatement("delete from otelkampanya where kamID=?");
           pst.setLong(1, k.getKamID());
           pst.executeUpdate();
           pst =con.prepareStatement("delete from kampanya where kamID=?");
           pst.setLong(1, k.getKamID());
           pst.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());}
        }
       
        public void update(kampanya k){
        Connection con =ConnectionManager.getConnection();
        try{
            Statement st =con.createStatement();
            String update="update kampanya set kamAdi=?,kamBilgi=?,kamBaslangic=?,kamBitis=? where kamID=?";
            PreparedStatement ps=con.prepareStatement(update);
            ps.setString(1, k.getKamAdi());
            ps.setString(2, k.getKamBilgi());
            ps.setString(3, k.getKamBaslangic());
            ps.setString(4, k.getKamBitis());
            ps.setLong(5, k.getKamID());
            ps.executeUpdate();
             ps=con.prepareStatement("delete from otelkampanya where kamID=?");
           ps.setLong(1, k.getKamID());
           ps.executeUpdate();
          
           for(otel ot:k.getOtelkampanya() ){
            ps=con.prepareStatement("insert into otelkampanya(otelID,kamID) values(?,?)");
            ps.setLong(1, ot.getOtelID());
            ps.setLong(2, k.getKamID());
            ps.executeUpdate();
          }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
         }
        }
        
    public void create(kampanya kam) {
       Connection con =ConnectionManager.getConnection();
        try{
            PreparedStatement pst =con.prepareStatement("insert into kampanya(kamAdi,kamBilgi,kamBaslangic,kamBitis) values(?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, kam.getKamAdi());
            pst.setString(2, kam.getKamBilgi());
            pst.setString(3, kam.getKamBaslangic());
            pst.setString(4, kam.getKamBitis());
            pst.executeUpdate();
            Long kamID=null;
             ResultSet gk=pst.getGeneratedKeys();
             if(gk.next()){
               kamID=gk.getLong(1);
             }
            for(otel ot: kam.getOtelkampanya()){
              pst=con.prepareStatement("insert into otelkampanya(otelID,kamID)values(?,?)");
               pst.setLong(1, ot.getOtelID());
               pst.setLong(2, kamID);
               pst.executeUpdate();
             }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
         }
    }

    private kampanya find(Long id) {
        Connection con=ConnectionManager.getConnection();
           kampanya k=null;
           try{
            PreparedStatement st=con.prepareStatement("select *from kampanya where kamID=?");
             st.setLong(1, id);
            ResultSet rs=st.executeQuery();
            rs.next();
            
            k=new kampanya();
            k.setKamID(rs.getLong("kamID"));
            k.setKamAdi(rs.getString("kamAdi"));
            k.setKamBilgi(rs.getString("kamBilgi"));
            k.setKamBaslangic(rs.getString("kamBaslangic"));
            k.setKamBitis(rs.getString("kamBitis"));
        
        }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
        return k;
      }
    }

